import data.*
import managers.*
import searchUtils.userRequestVehicleBrand
import searchUtils.userRequestVehicleModel
import utils.autoConstructor
import utils.commercialConstructor
import utils.motoConstructor
import validators.InputValidator
import java.util.*

fun main() {

    val ownerManager: OwnerManager = TestOwnerManager()
    val adsManager: AdsManager = TestAdsManager()
    val vehicleManager: VehicleManager = TestVehicleManager()
    val validator = InputValidator()

    do mainMenu(vehicleManager, ownerManager, adsManager, validator)
    while (true)

//    val allVehicles = vehicleManager.getAllVehicle()
//    allVehicles.forEach { vehicle ->
//        vehicle.getVehicleInfo()
//    }
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
                    "4. Снять объявление\n" +
                    "5. Поиск по объявлениям"
        )

        enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredSymbol == 0)

    when (enteredSymbol) {
        1 -> vehicleMenu(vehicleManager, validator)
        2 -> ownerConstructor(ownerManager, validator)
        3 -> adsConstructor(validator, adsManager)
        4 -> adsManager.removeAd(adsConstructor())
        5 -> researchAds(adsManager)
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
    println("Введите имя:")
    val name = readln()
    println("Введите номер телефона:")
    val telephoneNumber = readln().toLong()
    println("Введите email:")
    var email = readln()
    while (!validator.isValidEmail(email)) {
        println("Введите действительный email")
        email = readln()
    }
    val owner = Owner(
        UUID.randomUUID(),
        name,
        telephoneNumber,
        email
    )
    ownerManager.addOwner(owner)
}


fun adsConstructor(validator: InputValidator, adsManager: AdsManager) {
    val idVehicle = //TODO("Функция выбора нужного авто и возврат его ID")
    val idOwner = //TODO("Функция выбора пользователя и возврат его ID")
    val publicationDate = Date()
    println("Введите цену:")
    val price = readln().toInt()
    val ad = Ads(
        UUID.randomUUID(),
        price,
        publicationDate,
        idVehicle,
        idOwner
    )
    adsManager.addAd(ad)
    return
}

fun researchVehicle(validator: InputValidator, vehicleManager: VehicleManager, vehicle: Vehicle) {

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

    if (enteredSymbol == 1) {
        val brand = userRequestVehicleBrand(validator)
        val model = userRequestVehicleModel(brand?, validator)
    }
    if (enteredSymbol == 2) {
        val brand =
        val model =
        val userRequestVehicleSpecificInfo =
    }
    if (enteredSymbol == 3) {
        val brand =
        val model =
        val userRequestVehicleSpecificInfo =
    }
    if (enteredSymbol == 4) {
        val brand =
        val model =
        val userRequestVehicleSpecificInfo =
    }
    if (enteredSymbol == 5) {
        return
    }

    val year =
    val color =
    val mileage =

        vehicleManager.searchVehicle(brand, model, year, color, mileage, userRequestVehicleSpecificInfo)

    for (i in vehicleListOut) {
        vehicle.getVehicleInfo()
    }

}

fun researchAds(adsManager: TestAdsManager) {
//
//        val foundAd = adsManager.searchAds()
//    vehicle = foundAd.idVehicle
//        .getVehicleInfo()

}