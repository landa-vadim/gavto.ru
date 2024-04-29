import data.*
import data.vehicle.Vehicle
import managers.*
import searchUtils.*
import utils.*
import validators.InputValidator
import java.util.*
import javax.xml.validation.ValidatorHandler

fun main() {
    val ownerManager: OwnerManager = TestOwnerManager()
    val adsManager: AdsManager = TestAdsManager()
    val vehicleManager: VehicleManager = TestVehicleManager()
    val validator = InputValidator()
    var email: String? = ""
    do {
        email = validator.isValidEmail(readln())
    } while (email == null)

    do {
        mainMenu(vehicleManager, ownerManager, adsManager, validator)
    }
    while (true)
}

fun mainMenu(
    vehicleManager: VehicleManager,
    ownerManager: OwnerManager,
    adsManager: AdsManager,
    validator: InputValidator
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
        2 -> ownerConstructor(ownerManager, validator)
        3 -> adsConstructor(vehicleManager, ownerManager, adsManager)
        4 -> adPriceChange()
        5 -> removingAd()
        6 -> recoverAd()
        7 -> getFoundAds()
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

    if (choiceVehicleType == 1) {
        val autoWasAdded = autoConstructor(validator)
        if (autoWasAdded == null) return
        else {
            vehicleManager.addVehicle(autoWasAdded)
        }
    }
    if (choiceVehicleType == 2) {
        val motoWasAdded = motoConstructor(validator)
        if (motoWasAdded == null) return
        else {
            vehicleManager.addVehicle(motoWasAdded)
        }
    }
    if (choiceVehicleType == 3) {
        val commercialWasAdded = commercialConstructor(validator)
        if (commercialWasAdded == null) return
        else {
            vehicleManager.addVehicle(commercialWasAdded)
        }
    }
}

fun ownerConstructor(ownerManager: OwnerManager, validator: InputValidator) {

    val name = getOwnerName()
    val telephoneNumber = getTelephoneNumber()
    val email = getOwnerEmail()

    val owner = Owner(
        UUID.randomUUID(),
        name,
        telephoneNumber,
        email
    )
    ownerManager.addOwner(owner)
}

fun adsConstructor(vehicleManager: VehicleManager, ownerManager: OwnerManager, adsManager: AdsManager) {

    val vehicle = vehicleManager.getVehicleFromList()
    val owner = ownerManager.getOwnerFromList()
    val setPrice = PriceRecord(getAdDate(), getAdPrice())
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

fun adPriceChange() {

    println("Выберете объявление из списка, для которого хотите поменять цену:")
    val ad = adsManager.chooseAds()
    val setNewPrice = PriceRecord(getAdDate(), getAdPrice())
    ad.priceHistory.add(setNewPrice)
}

fun removingAd() {

    adsManager.removeAd(adsManager.chooseAds())
}

fun recoverAd() {

    adsManager.recoverAd(adsManager.chooseRemovedAds())
}

fun researchVehicle(validator: InputValidator, vehicleManager: TestVehicleManager): List<Vehicle>? {

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
    val userRequestVehicleSpecificInfo = userRequestSpecificInfo(enteredSymbol, validator)

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

fun getFoundAds() {

    val adsFoundedList = adsManager.searchAds()
    if (adsFoundedList == null) {
        println("Объявлений с указанными параметрами не найдено!")
        return
    } else adsFoundedList.forEach { ad ->
        ad.getAdInfo()
    }
}