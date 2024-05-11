import data.*
import data.vehicle.Vehicle
import managers.*
import searchUtils.*
import utils.*
import validators.InputValidator
import java.util.*

fun main() {
    val ownerManager: OwnerManager = JsonOwnerManager()
    val adsManager: AdsManager = JsonAdsManager()
    val vehicleManager: VehicleManager = JsonVehicleManager()
    val validator = InputValidator()
    do {
        mainMenu(vehicleManager, ownerManager, adsManager, validator)
    } while (true)
}

fun mainMenu(
    vehicleManager: VehicleManager,
    ownerManager: OwnerManager,
    adsManager: AdsManager,
    validator: InputValidator,
) {
    var enteredSymbol = 0
    do {
        println(
            "1. Добавить новое ТС\n" +
                    "2. Добавить нового владельца\n" +
                    "3. Добавить объявление\n" +
                    "4. Изменить цену в объявлении\n" +
                    "5. Снять объявление\n" +
                    "6. Восстановить снятое объявление\n" +
                    "7. Поиск по объявлениям"
        )
        enteredSymbol = validator.isStringValidInRange(readln(), 1..7)
    } while (enteredSymbol == 0)
    when (enteredSymbol) {
        1 -> vehicleMenu(vehicleManager, validator)
        2 -> ownerCreator(ownerManager, validator)
        3 -> adsCreator(vehicleManager, ownerManager, adsManager, validator)
        4 -> adPriceChange(adsManager, validator)
        5 -> removingAd(adsManager, validator)
        6 -> recoverAd(adsManager, validator)
        7 -> getFoundAds(vehicleManager, adsManager, validator)
        else -> return
    }
}

fun vehicleMenu(vehicleManager: VehicleManager, validator: InputValidator) {
    println(
        "1. Добавить автомобиль\n" +
                "2. Добавить мотоцикл\n" +
                "3. Добавить коммерческий авто\n" +
                "4. Назад"
    )
    var choiceVehicleType = 0
    do {
        choiceVehicleType = validator.isStringValidInRange(readln(), 1..4)
    } while (choiceVehicleType == 0)
    val vehicle = when (choiceVehicleType) {
        1 -> autoCreator(validator)
        2 -> motoCreator(validator)
        3 -> commercialCreator(validator)
        else -> null
    }
    vehicle?.let { vehicleManager.addVehicle(it) }
}

fun ownerCreator(ownerManager: OwnerManager, validator: InputValidator) {
    val owner = Owner(
        idOwner = UUID.randomUUID(),
        name = getOwnerName(validator),
        telephoneNumber = getTelephoneNumber(validator),
        email = getOwnerEmail(validator)
    )
    ownerManager.addOwner(owner)
}

fun adsCreator(
    vehicleManager: VehicleManager,
    ownerManager: OwnerManager,
    adsManager: AdsManager,
    validator: InputValidator
) {
    val vehicleList = vehicleManager.getAllVehicle()
    val ownerList = ownerManager.getAllOwners()
    val allAdsList = adsManager.getAllAds()
    if (vehicleList.isEmpty() || ownerManager.getAllOwners().isEmpty()) return
    val vehicleWithoutAdsList = vehicleList.filter { vehicle ->
        !allAdsList.map { it.vehicle }.contains(vehicle)
    }
    val vehicle = getVehicleFromList(vehicleWithoutAdsList, validator) ?: return
    val owner = getOwnerFromList(ownerList, validator) ?: return
    val setPrice = PriceRecord(getAdDate(), getAdPrice(validator))
    val priceHistory = mutableListOf<PriceRecord>()
    priceHistory.add(setPrice)
    val ad = Ads(
        UUID.randomUUID(),
        vehicle,
        owner,
        priceHistory
    )
    adsManager.addAd(ad)
}

fun adPriceChange(adsManager: AdsManager, validator: InputValidator) {
    if (adsManager.getAllAds().isEmpty()) return
    adsManager.printAllAds()
    println("Выберете объявление из списка, для которого хотите поменять цену:")
    val ad = chooseAdsUI(adsManager, validator)
    val setNewPrice = PriceRecord(getAdDate(), getAdPrice(validator))
    ad.priceHistory.add(setNewPrice)
}

fun removingAd(adsManager: AdsManager, validator: InputValidator) {
    if (adsManager.getAllAds().isEmpty()) return
    adsManager.printAllAds()
    val ad = chooseAdsUI(adsManager, validator)
    removeAdUI(ad, adsManager)
}

fun recoverAd(adsManager: AdsManager, validator: InputValidator) {
    if (adsManager.getAllRemovedAds().isEmpty()) return
    val removedAd = chooseRemovedAdsUI(adsManager, validator)
    adsManager.recoverAd(removedAd)
    println("Объявление опубликовано вновь!")
}

fun researchVehicle(validator: InputValidator, vehicleManager: VehicleManager): List<Vehicle>? {
    if (vehicleManager.getAllVehicle().isEmpty()) return null
    println(
        "1. Поиск по всем ТС\n" +
                "2. Поиск по авто\n" +
                "3. Поиск по мото\n" +
                "4. Поиск по коммерческому транспорту\n" +
                "5. Назад"
    )
    var enteredSymbol = 0
    do enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    while (enteredSymbol == 0)
    val brand =
        when (enteredSymbol) {
            1 -> userRequestVehicleBrand(validator)
            2 -> userRequestAutoBrand(validator)
            3 -> userRequestMotoBrand(validator)
            4 -> userRequestCommercialBrand(validator)
            else -> return null
        }
    val model =
        when (enteredSymbol) {
            1 -> userRequestVehicleModel(brand, validator)
            2 -> userRequestAutoModel(brand, validator)
            3 -> userRequestMotoModel(brand, validator)
            4 -> userRequestCommercialModel(brand, validator)
            else -> return null
        }
    val year = userRequestVehicleYear(validator)
    val color = userRequestVehicleColor(validator)
    val mileage = userRequestVehicleMileage(validator)
    val userRequestVehicleSpecificInfo = userRequestSpecificInfo(enteredSymbol, validator, model)
    val vehicleListFounded =
        vehicleManager.searchVehicle(
            brand,
            model,
            year,
            color,
            mileage,
            userRequestVehicleSpecificInfo,
        )
    return vehicleListFounded
}

fun getFoundAds(vehicleManager: VehicleManager, adsManager: AdsManager, validator: InputValidator) {
    if (vehicleManager.getAllVehicle().isEmpty() || adsManager.getAllAds().isEmpty()) return
    val foundVehicleList = researchVehicle(validator, vehicleManager)
    val adsFoundedList = adsManager.searchAds(foundVehicleList)
    if (adsFoundedList == null) {
        println("Объявлений с указанными параметрами не найдено!")
        return
    } else adsFoundedList.forEach { ad ->
        ad.getAdInfo()
    }
}

fun getVehicleFromList(vehicleWithoutAdsList: List<Vehicle>, validator: InputValidator): Vehicle? {
    vehicleWithoutAdsList.forEachIndexed { index, vehicle ->
        println("${index + 1}.")
        vehicle.getVehicleInfo()
    }
    println("Введите номер ТС, который вы хотите добавить в объявление или \"0\" для возврата в главное меню:")
    val choice = validator.isStringValidInRange(readln(), 1..vehicleWithoutAdsList.count())
    return if (choice == 0) null else vehicleWithoutAdsList[choice - 1]
}

fun getOwnerFromList(ownerList: List<Owner>, validator: InputValidator): Owner? {
    ownerList.forEachIndexed { index, owner ->
        println("${index + 1}.")
        owner.getOwnerInfo()
    }
    println("Найдите свои данные в списке и введите соответствующий номер или \"0\" для возврата в главное меню:")
    val choice = validator.isStringValidInRange(readln(), 1..ownerList.count())
    return if (choice == 0) null else ownerList[choice - 1]
}

fun removeAdUI(ad: Ads, adsManager: AdsManager) {
    println("Введите причину снятия объявления:")
    val reason = readln()
    adsManager.removeAd(ad, reason)
    println("Объявление снято с публикации!")
}

fun chooseAdsUI(adsManager: AdsManager, validator: InputValidator): Ads {
    println("Список всех объявлений:")
    adsManager.getAllAds()
    println("Выберете номер объявления:")
    val activeAdsList = adsManager.getAllAds()
    val count = activeAdsList.count()
    val adNumber = validator.isStringValidInRange(readln(), 1..count) - 1
    val ad = adsManager.chooseAds(adNumber)
    return ad
}

fun chooseRemovedAdsUI(adsManager: AdsManager, validator: InputValidator): RemovedAds {
    println("Список всех снятых объявлений:")
    adsManager.printAllRemovedAds()
    println("Выберете номер объявления:")
    val inActiveAdsList = adsManager.getAllRemovedAds()
    val count = inActiveAdsList.count()
    val adNumber = validator.isStringValidInRange(readln(), 1..count) - 1
    val removedAd = adsManager.chooseRemovedAds(adNumber)
    return removedAd
}