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
        brand = Brand.BMW,
        model = BmwAutoModel(BmwAutoModels.M5),
        year = 2019,
        color = Color.BLUE,
        mileage = 40000,
        typeAuto = TypeAuto.SEDAN
    )
    vehicleManager.addVehicle(auto1)

    val moto1 = Moto(
        brand = Brand.YAMAHA,
        model = YamahaMotoModel(YamahaMotoModels.XV),
        year = 2015,
        color = Color.BLACK,
        mileage = 20000,
        typeMoto = TypeMoto.SPORT
    )

    val commercial1 = Commercial(
        brand = Brand.VOLKSWAGEN,
        model = VolksWagenCommercialModel(VolksWagenCommercialModels.CADDY),
        year = 2014,
        color = Color.BLACK,
        mileage = 20000,
        loadCapacity = 1.5
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
    var enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    while (enteredSymbol == 0) {
        enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    }
    if (enteredSymbol == 1) {
        return vehicleConstructor(vehicleManager, validator)
    }
    if (enteredSymbol == 2) {
        return ownerConstructor(ownerManager, validator)
    }
    if (enteredSymbol == 3) {
        println("Введите данные авто, для которого хотите создать объявление:")
//      val vehicle = функция поиска авто, которая в инпут получает свойства вехайкла, а в аутпут кладет найденный вехайкл из листа
//      TestVehicleManager.searchVehicle(vehicle)
//      adsConstructor(adsManager)
        return false
    }
    if (enteredSymbol == 4) {
//        adsManager.removeAd(adsConstructor)
        return false
    }
    if (enteredSymbol == 5) {
//        adsManager.searchAds(adsConstructor())
        return false
    } else return false
}


fun vehicleConstructor(vehicleManager: VehicleManager, validator: InputValidator): Boolean {

    println("1. Добавить автомобиль\n2. Добавить мотоцикл\n3. Добавить коммерческий авто\n4. Назад")
    var choiceVehicleType = 0
    do validator.isStringValidInRange(readln(), 1..4)
    while (choiceVehicleType == 0)
    if (choiceVehicleType == 1) {
        addAuto(vehicleManager, validator)
    }
    if (choiceVehicleType == 2) {
        addMoto(vehicleManager, validator)
    }
    if (choiceVehicleType == 3) {
        addCommercial(vehicleManager, validator)
    }

    var enteredBrand = 0
    do validator.isStringValidInRange(readln(), 1..6)
    while (enteredBrand == 0)
    val brandChoice =
        when (enteredBrand) {
            1 -> Brand.AUDI
            2 -> Brand.BMW
            3 -> Brand.MAZDA
            4 -> Brand.KIA
            5 -> Brand.SKODA
            else -> return false
        }

    when (enteredBrand) {
        1 -> println("Выберете модель:\n1. A3\n2. A4\n3. A6\n4. Q3\n5. Q5\n6. Назад")
        2 -> println("Выберете модель:\n1. M3\n2. M5\n3. M7\n4. X5\n5. X6\n6. Назад")
        3 -> println("Выберете модель:\n1. M3\n2. M6\n3. CX-30\n4. CX-5\n5. CX-9\n6. Назад")
        4 -> println("Выберете модель:\n1. Rio\n2. Cerato\n3. Optima\n4. Sportage\n5. Sorento\n6. Назад")
        5 -> println("Выберете модель:\n1. Rapid\n2. Octavia\n3. Superb\n4. Karoq\n5. Kodiaq\n6. Назад")
    }
    var enteredModel = 0

    do validator.isStringValidInRange(readln(), 1..6)
    while (enteredModel == 0)
    if (enteredModel == 6)

        return false
    val pickBrand =
        when (brandChoice) {
            Brand.AUDI -> AudiAutoModels.getById(enteredModel - 1)
            Brand.BMW -> BmwAutoModels.getById(enteredModel - 1)
            Brand.MAZDA -> MazdaAutoModels.getById(enteredModel - 1)
            Brand.KIA -> KiaAutoModels.getById(enteredModel - 1)
            Brand.SKODA -> SkodaAutoModels.getById(enteredModel - 1)
            else -> return false
        }


    println("Введите год выпуска:")
    var enteredYear = validator.isYearValid(readln())
    while (enteredYear == 0) {
        enteredYear = validator.isYearValid(readln())
    }
    println("Выберете цвет:\n1. Красный\n 2. Зеленый\n3. Синий\n4. Черный\n5. Белый\n6. Назад")
    var enteredColor = validator.isStringValidInRange(readln(), 1..6)
    while (enteredColor == 0) {
        enteredColor = validator.isStringValidInRange(readln(), 1..6)
    }

    val choiceColor =
        when (enteredColor) {
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.BLUE
            4 -> Color.BLACK
            5 -> Color.WHITE
            else -> Color.UNKNOWN
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
            brandChoice,
            modelChoice,
            enteredYear,
            choiceColor,
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
            }
        val vehicle = Moto(
            brandChoice,
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
            brandChoice,
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

fun addAuto(vehicleManager: VehicleManager, validator: InputValidator): Auto {
    auto = Auto(
        brand = chooseBrand(validator),
        model = chooseModel(validator, brand),


    )

}

fun addMoto(vehicleManager: VehicleManager, validator: InputValidator): Moto {

}

fun addCommercial(vehicleManager: VehicleManager, validator: InputValidator): Commercial {

}

fun chooseBrand(validator: InputValidator): Brand {
    println(
        "Выберете марку:\n" +
                "1. Audi\n" +
                "2. BMW\n" +
                "3. Mazda\n" +
                "4. KIA\n" +
                "5. Skoda\n" +
                "6. Назад"
    )
    var enteredBrand = 0
    do {
        enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredBrand == 0)

    val brandChoice =
        when (enteredBrand) {
            1 -> Brand.AUDI
            2 -> Brand.BMW
            3 -> Brand.MAZDA
            4 -> Brand.KIA
            5 -> Brand.SKODA
            6 -> TODO("Жёпа")
        }
    return brandChoice
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