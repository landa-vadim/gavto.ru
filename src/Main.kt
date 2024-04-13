import data.*
import managers.*
import validators.InputValidator
import java.util.*

fun main() {


    val ownerManager: OwnerManager = TestOwnerManager()
    val adsManager: AdsManager = TestAdsManager()
    val vehicleManager: VehicleManager = TestVehicleManager()
    val validator = InputValidator()

    mainMenu(vehicleManager, ownerManager, adsManager, validator)

//    createVehicleForSearch()

    val allVehicles = vehicleManager.getAllVehicle()
    allVehicles.forEach { vehicle ->
        vehicle.getVehicleInfo()
        if (vehicle is Auto) {
            println(vehicle.typeAuto)
        }
        if (vehicle is Moto) {
            println(vehicle.typeMoto)
        }
        if (vehicle is Commercial) {
            println(vehicle.loadCapacity)
        }
    }

    val auto1 = Auto(
        brand = "BMW",
        model = "3",
        year = 2019,
        color = Color.BLUE,
        mileage = 40000,
        typeAuto = TypeAuto.SEDAN
    )
    vehicleManager.addVehicle(auto1)

    val moto1 = Moto(
        brand = "Yamaha",
        model = "5",
        year = 2015,
        color = Color.BLACK,
        mileage = 20000,
        typeMoto = TypeMoto.SPORT
    )

    vehicleManager.addVehicle(moto1)


    val owner1 = Owner(
        name = "Иван",
        telephoneNumber = 89905578121,
        email = "google.ivan@gmail.com"
    )


    val ad1 = Ads(
        price = 3000000,
        publicationDate = Date(),
        idOwner = owner1.idOwner,
        idVehicle = auto1.idVehicle
    )

}

fun search(usersChoice: Int) {

}


fun mainMenu(
    vehicleManager: VehicleManager,
    ownerManager: OwnerManager,
    adsManager: AdsManager,
    validator: InputValidator
): Boolean {

    println("1. Добавить новое ТС\n2. Добавить нового владельца\n3. Добавить объявление\n4. Снять объявление\n5. Поиск по объявлениям")
    var enteredSymbol = (readln())
    while (validator.isStringValidInRange(enteredSymbol, 1..5) == 0) {
        enteredSymbol = (readln())
    }
    val numberOfChoice = (enteredSymbol.toCharArray())[0].digitToInt()
    if (numberOfChoice == 1) {
        return vehicleConstructor(vehicleManager, validator)
    }
    if (numberOfChoice == 2) {
        return ownerConstructor(ownerManager, validator)
    }
    if (numberOfChoice == 3) {
        println("Введите данные авто, для которого хотите создать объявление:")
//      val vehicle = функция поиска авто, которая в инпут получает свойства вехайкла, а в аутпут кладет найденный вехайкл из листа
//      TestVehicleManager.searchVehicle(vehicle)
//      adsConstructor(adsManager)
        return false
    }
    if (numberOfChoice == 4) {
//        adsManager.removeAd(adsConstructor)
        return false
    }
    if (numberOfChoice == 5) {
//        adsManager.searchAds(adsConstructor())
        return false
    } else return false
}


fun vehicleConstructor(vehicleManager: VehicleManager, validator: InputValidator): Boolean {

    println("1. Добавить автомобиль\n2. Добавить мотоцикл\n3. Добавить коммерческий авто\n4. Назад")
    var choiceVehicleType = validator.isStringValidInRange(readln(), 1..4)
    while (choiceVehicleType == 0) {
        choiceVehicleType = validator.isStringValidInRange(readln(), 1..4)
    }
    if (choiceVehicleType == 1) {
        println("Выберете марку:\n1. Audi\n2. BMW\n3. Mazda\n4. KIA\n5. Skoda\n6. Назад")
        var enteredBrand = validator.isStringValidInRange(readln(), 1..6)
        while (enteredBrand == 0) {
            enteredBrand = validator.isStringValidInRange(readln(), 1..6)
        }
        enteredBrand =
            when (enteredBrand) {
            1 -> BrandAuto.AUDI
            2 -> BrandAuto.BMW
            3 -> BrandAuto.MAZDA
            4 -> BrandAuto.KIA
            5 -> BrandAuto.SKODA
        }
        println("Введите модель:")
        val enteredModel = readln()
        println("Введите год выпуска:")
        var enteredYear = validator.isYearValid(readln())
        while (enteredYear == 0) {
            enteredYear = validator.isYearValid(readln())
        }
        println("Выберете цвет:\n1. Красный\n 2. Зеленый\n3. Синий\n4. Черный\n5. Белый\n6. Назад")
        var choiceColor = validator.isStringValidInRange(readln(), 1..6)
        while (choiceColor == 0) {
            choiceColor = validator.isStringValidInRange(readln(), 1..6)
        }
        val enteredColor =
            when (choiceColor) {
                1 -> Color.RED
                2 -> Color.GREEN
                3 -> Color.BLUE
                4 -> Color.BLACK
                5 -> Color.WHITE
            }
        println("Введите верхнюю границу пробега:")
        val enteredMaxMileage = readln().toInt()
        if (choiceVehicleType == 1) {
            println("Выберете тип кузова:\n1. Седан\n 2. Хэтчбэк\n3. Универсал")
            val enteredTypeAuto: TypeAuto
            val enteredSymbol = readln().toInt()
            enteredTypeAuto =
                when (enteredSymbol) {
                    1 -> TypeAuto.SEDAN
                    2 -> TypeAuto.HATCHBACK
                    3 -> TypeAuto.UNIVERSAL
                    else -> TypeAuto.UNKNOWN
                }
            val vehicle = Auto(
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredTypeAuto
            )
            vehicleManager.addVehicle(vehicle)
            return true
        }
        if (choiceVehicleType == 2) {
            println("Выберете тип мотоцикла:\n1. Кроссовый\n2. Спортивный\n3. Грантуризмо")
            val enteredTypeMoto: TypeMoto
            val enteredSymbol = readln().toInt()
            enteredTypeMoto =
                when (enteredSymbol) {
                    1 -> TypeMoto.CROSS
                    2 -> TypeMoto.SPORT
                    3 -> TypeMoto.GRANTURISMO
                    else -> TypeMoto.UNKNOWN
                }
            val vehicle = Moto(
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredTypeMoto
            )
            vehicleManager.addVehicle(vehicle)
            return true
        }
        if (choiceVehicleType == 3) {
            println("Введите грузоподъемность:")
            val enteredLoadCapacity = readln().toDouble()
            val vehicle = Commercial(
                enteredBrand,
                enteredModel,
                enteredYear,
                enteredColor,
                enteredMaxMileage,
                enteredLoadCapacity
            )
            vehicleManager.addVehicle(vehicle)
            return true
        } else return false
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