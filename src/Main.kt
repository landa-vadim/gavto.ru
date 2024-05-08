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
    val allAdsList = adsManager.getAllAds()
    if (vehicleList.isEmpty() || ownerManager.getAllOwners().isEmpty()) return
    val vehicleWithoutAdsList = vehicleList.filter { vehicle ->
        !allAdsList.map { it.vehicle } .contains(vehicle)
    }
    val vehicle = vehicleManager.getVehicleFromList(vehicleWithoutAdsList) ?: return
    val owner = ownerManager.getOwnerFromList(validator) ?: return
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
    val ad = adsManager.chooseAds(validator)
    val setNewPrice = PriceRecord(getAdDate(), getAdPrice(validator))
    ad.priceHistory.add(setNewPrice)
}

fun removingAd(adsManager: AdsManager, validator: InputValidator) {
    if (adsManager.getAllAds().isEmpty()) return
    adsManager.printAllAds()
    adsManager.removeAd(adsManager.chooseAds(validator))
}

fun recoverAd(adsManager: AdsManager, validator: InputValidator) {
    if (adsManager.getAllRemovedAds().isEmpty()) return
    adsManager.recoverAd(adsManager.chooseRemovedAds(validator))
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