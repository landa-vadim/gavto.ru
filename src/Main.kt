import data.*
import managers.*
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

    mainMenu(vehicleManager, ownerManager, adsManager, validator)

    val allVehicles = vehicleManager.getAllVehicle()
    allVehicles.forEach { vehicle ->
        vehicle.getVehicleInfo()
    }
}

fun mainMenu(
    vehicleManager: VehicleManager,
    ownerManager: OwnerManager,
    adsManager: AdsManager,
    validator: InputValidator
): Boolean {

    var enteredSymbol = 0
    do {
        println("1. Добавить новое ТС\n" +
                "2. Добавить нового владельца\n" +
                "3. Добавить объявление\n" +
                "4. Снять объявление\n" +
                "5. Поиск по объявлениям")

        enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredSymbol == 0)

    when (enteredSymbol) {
        1 -> return vehicleMenu(vehicleManager, validator)
        2 -> return ownerConstructor(ownerManager, validator)
//        3 -> return adsConstructor()
//        4 -> return adsManager.removeAd(adsConstructor())
//        5 -> return adsManager.searchAds(adsConstructor())
        else -> return false
    }
}


fun vehicleMenu(vehicleManager: VehicleManager, validator: InputValidator): Boolean {
    println("1. Добавить автомобиль\n2. Добавить мотоцикл\n3. Добавить коммерческий авто\n4. Назад")
    var choiceVehicleType = 0
    do {
        choiceVehicleType = validator.isStringValidInRange(readln(), 1..4)
    }
    while (choiceVehicleType == 0)

    if (choiceVehicleType == 1) {
        val autoWasAdded = autoConstructor(validator)
        if (autoWasAdded == null) return false
        else {
            vehicleManager.addVehicle(autoWasAdded)
            return true
        }
    }
    if (choiceVehicleType == 2) {
        val motoWasAdded = motoConstructor(validator)
        if (motoWasAdded == null) return false
        else {
            vehicleManager.addVehicle(motoWasAdded)
            return true
        }
    }
    if (choiceVehicleType == 3) {
        val commercialWasAdded = commercialConstructor(validator)
        if (commercialWasAdded == null) return false
        else {
            vehicleManager.addVehicle(commercialWasAdded)
            return true
        }
    } else return false
}

fun ownerConstructor(ownerManager: OwnerManager, validator: InputValidator): Boolean {
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
    return true
}


fun adsConstructor(vehicle: Vehicle, owner: Owner, adsManager: AdsManager): Boolean {
    val idVehicle = vehicle.idVehicle
    val idOwner = owner.idOwner
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
    return true
}

fun search(usersChoice: Int) {

}