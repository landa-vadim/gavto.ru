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
        println("1. Добавить новое ТС\n2. Добавить нового владельца\n3. Добавить объявление\n4. Снять объявление\n5. Поиск по объявлениям")
        enteredSymbol = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredSymbol == 0)

    when (enteredSymbol) {
        1 -> return vehicleConstructor(vehicleManager, validator)
        2 -> return ownerConstructor(ownerManager, validator)
        3 -> return adsConstructor()
        4 -> return adsManager.removeAd(adsConstructor())
        5 -> return adsManager.searchAds(adsConstructor())
        else -> return false
    }
}


fun vehicleConstructor(vehicleManager: VehicleManager, validator: InputValidator): Boolean {

    println("1. Добавить автомобиль\n2. Добавить мотоцикл\n3. Добавить коммерческий авто\n4. Назад")
    var choiceVehicleType = 0
    do choiceVehicleType = validator.isStringValidInRange(readln(), 1..4)
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


fun autoConstructor(validator: InputValidator): Auto? {

    var enteredBrand = 0
    do {
        println(
            "Выберете марку:\n" +
                    "1. Audi\n" +
                    "2. BMW\n" +
                    "3. Mazda\n" +
                    "4. KIA\n" +
                    "5. Skoda\n" +
                    "6. Назад"
        )
        enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredBrand == 0)
    val brandChoice =
        when (enteredBrand) {
            1 -> Brand.AUDI
            2 -> Brand.BMW
            3 -> Brand.MAZDA
            4 -> Brand.KIA
            5 -> Brand.SKODA
            else -> return null
        }

    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.AUDI -> println(
                "Выберете модель:\n+" +
                        "1. A3\n" +
                        "2. A4\n" +
                        "3. A6\n" +
                        "4. Q3\n" +
                        "5. Q5"
            )

            Brand.BMW -> println(
                "Выберете модель:\n" +
                        "1. M3\n" +
                        "2. M5\n" +
                        "3. M7\n" +
                        "4. X5\n" +
                        "5. X6"
            )

            Brand.MAZDA -> println(
                "Выберете модель:\n" +
                        "1. M3\n" +
                        "2. M6\n" +
                        "3. CX-30\n" +
                        "4. CX-5\n" +
                        "5. CX-9"
            )

            Brand.KIA -> println(
                "Выберете модель:\n" +
                        "1. Rio\n" +
                        "2. Cerato\n" +
                        "3. Optima\n" +
                        "4. Sportage\n" +
                        "5. Sorento"
            )

            Brand.SKODA -> println(
                "Выберете модель:\n" +
                        "1. Rapid\n" +
                        "2. Octavia\n" +
                        "3. Superb\n" +
                        "4. Karoq\n" +
                        "5. Kodiaq"
            )

            else -> return null
        }
        enteredModel = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredModel == 0)
    val modelChoice =
        when (brandChoice) {
            Brand.AUDI -> AudiAutoModel(AudiAutoModels.getById(enteredModel - 1))
            Brand.BMW -> BmwAutoModel(BmwAutoModels.getById(enteredModel - 1))
            Brand.MAZDA -> MazdaAutoModel(MazdaAutoModels.getById(enteredModel - 1))
            Brand.KIA -> KiaAutoModel(KiaAutoModels.getById(enteredModel - 1))
            Brand.SKODA -> SkodaAutoModel(SkodaAutoModels.getById(enteredModel - 1))
            else -> return null
        }

    var enteredYear = 0
    do {
        println("Введите год выпуска:")
        enteredYear = validator.isYearValid(readln())
    } while (enteredYear == 0)


    var enteredColor = 0
    do {
        println(
            "Выберете цвет:\n" +
                    "1. Красный\n" +
                    "2. Зеленый\n" +
                    "3. Синий\n" +
                    "4. Черный\n" +
                    "5. Белый"
        )
        enteredColor = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredColor == 0)
    val colorChoice =
        when (enteredColor) {
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.BLUE
            4 -> Color.BLACK
            5 -> Color.WHITE
            else -> return null
        }

    var enteredMileage = 0
    do {
        println("Введите пробег:")
        enteredMileage = validator.isStringValidInRange(readln(), 0..5000000)
    } while (enteredMileage == 0)

    var enteredTypeAuto = 0
    do {
        println(
            "Выберете тип кузова:\n" +
                    "1. Седан\n" +
                    "2. Хэтчбэк\n" +
                    "3. Универсал"
        )
        enteredTypeAuto = validator.isStringValidInRange(readln(), 1..3)
    } while (enteredTypeAuto == 0)
    val typeAutoChoice =
        when (enteredTypeAuto) {
            1 -> TypeAuto.SEDAN
            2 -> TypeAuto.HATCHBACK
            3 -> TypeAuto.UNIVERSAL
            else -> return null
        }

    val auto = Auto(
        brand = brandChoice,
        model = modelChoice,
        year = enteredYear,
        color = colorChoice,
        mileage = enteredMileage,
        typeAuto = typeAutoChoice
    )

    return auto

}

fun motoConstructor(validator: InputValidator): Moto? {

    println(
        "Выберете марку:\n" +
                "1. BMW\n" +
                "2. Yamaha\n" +
                "3. Kawasaki\n" +
                "4. Ural\n" +
                "5. Honda\n" +
                "6. Назад"
    )
    var enteredBrand = 0
    do enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    while (enteredBrand == 0)
    val brandChoice =
        when (enteredBrand) {
            1 -> Brand.BMW
            2 -> Brand.YAMAHA
            3 -> Brand.KAWASAKI
            4 -> Brand.URAL
            5 -> Brand.HONDA
            else -> return null
        }

    when (brandChoice) {
        Brand.BMW -> println(
            "Выберете модель:\n+" +
                    "1. M\n" +
                    "2. K\n" +
                    "3. G\n" +
                    "4. R\n" +
                    "5. C"
        )

        Brand.YAMAHA -> println(
            "Выберете модель:\n" +
                    "1. MT\n" +
                    "2. XSR\n" +
                    "3. XT\n" +
                    "4. XV\n" +
                    "5. YZF"
        )

        Brand.KAWASAKI -> println(
            "Выберете модель:\n" +
                    "1. EN\n" +
                    "2. ER\n" +
                    "3. KX\n" +
                    "4. NINJA,\n" +
                    "5. Z"
        )

        Brand.URAL -> println(
            "Выберете модель:\n" +
                    "1. M\n" +
                    "2. Solo\n" +
                    "3. Tourist\n" +
                    "4. Voyazh\n" +
                    "5. Wolf"
        )

        Brand.HONDA -> println(
            "Выберете модель:\n" +
                    "1. CB\n" +
                    "2. CBF\n" +
                    "3. CBR\n" +
                    "4. CRF\n" +
                    "5. GL"
        )

        else -> return null
    }
    var enteredModel = 0
    do enteredModel = validator.isStringValidInRange(readln(), 1..5)
    while (enteredModel == 0)
    val modelChoice =
        when (brandChoice) {
            Brand.BMW -> BmwMotoModel(BmwMotoModels.getById(enteredModel - 1))
            Brand.YAMAHA -> YamahaMotoModel(YamahaMotoModels.getById(enteredModel - 1))
            Brand.KAWASAKI -> KawasakiMotoModel(KawasakiMotoModels.getById(enteredModel - 1))
            Brand.URAL -> UralMotoModel(UralMotoModels.getById(enteredModel - 1))
            Brand.HONDA -> HondaMotoModel(HondaMotoModels.getById(enteredModel - 1))
            else -> return null
        }

    println("Введите год выпуска:")
    var enteredYear = 0
    do enteredYear = validator.isYearValid(readln())
    while (enteredYear == 0)

    println(
        "Выберете цвет:\n" +
                "1. Красный\n" +
                "2. Зеленый\n" +
                "3. Синий\n" +
                "4. Черный\n" +
                "5. Белый"
    )
    var enteredColor = 0
    do enteredColor = validator.isStringValidInRange(readln(), 1..5)
    while (enteredColor == 0)
    val colorChoice =
        when (enteredColor) {
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.BLUE
            4 -> Color.BLACK
            5 -> Color.WHITE
            else -> return null
        }

    println("Введите пробег:")
    var enteredMileage = 0
    do enteredMileage = validator.isStringValidInRange(readln(), 0..5000000)
    while (enteredMileage == 0)

    println(
        "Выберете тип мотоцикла:\n" +
                "1. Кроссовый\n" +
                "2. Спортивный\n" +
                "3. Грантуризмо"
    )
    var enteredTypeMoto = 0
    do enteredTypeMoto = validator.isStringValidInRange(readln(), 1..3)
    while (enteredTypeMoto == 0)
    val typeMotoChoice =
        when (enteredTypeMoto) {
            1 -> TypeMoto.CROSS
            2 -> TypeMoto.SPORT
            3 -> TypeMoto.GRANTURISMO
            else -> return null
        }

    val moto = Moto(
        brand = brandChoice,
        model = modelChoice,
        year = enteredYear,
        color = colorChoice,
        mileage = enteredMileage,
        typeMoto = typeMotoChoice
    )

    return moto

}


fun commercialConstructor(validator: InputValidator): Commercial? {

    var enteredBrand = 0
    do {
        println(
            "Выберете марку:\n" +
                    "1. Citroen\n" +
                    "2. Lada\n" +
                    "3. Peugeot\n" +
                    "4. Renault\n" +
                    "5. VolksWagen\n" +
                    "6. Назад"
        )
        enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredBrand == 0)
    val brandChoice =
        when (enteredBrand) {
            1 -> Brand.CITROEN
            2 -> Brand.LADA
            3 -> Brand.PEUGEOT
            4 -> Brand.RENAULT
            5 -> Brand.VOLKSWAGEN
            else -> return null
        }

    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.CITROEN -> println(
                "Выберете модель:\n+" +
                        "1. Berlingo"
            )

            Brand.LADA -> println(
                "Выберете модель:\n" +
                        "1. Largus"
            )

            Brand.PEUGEOT -> println(
                "Выберете модель:\n" +
                        "1. Partner"
            )

            Brand.RENAULT -> println(
                "Выберете модель:\n" +
                        "1. Dokker"
            )

            Brand.VOLKSWAGEN -> println(
                "Выберете модель:\n" +
                        "1. Caddy"
            )

            else -> return null
        }
        enteredModel = validator.isStringValidInRange(readln(), 1..1)
    } while (enteredModel == 0)
    val modelChoice =
        when (brandChoice) {
            Brand.CITROEN -> CitroenCommercialModel(CitroenCommercialModels.getById(enteredModel - 1))
            Brand.LADA -> LadaCommercialModel(LadaCommercialModels.getById(enteredModel - 1))
            Brand.PEUGEOT -> PeugeotCommercialModel(PeugeotCommercialModels.getById(enteredModel - 1))
            Brand.RENAULT -> RenaultCommercialModel(RenaultCommercialModels.getById(enteredModel - 1))
            Brand.VOLKSWAGEN -> VolksWagenCommercialModel(VolksWagenCommercialModels.getById(enteredModel - 1))
            else -> return null
        }


    var enteredYear = 0
    do {
        println("Введите год выпуска:")
        enteredYear = validator.isYearValid(readln())
    } while (enteredYear == 0)

    var enteredColor = 0
    do {
        println(
            "Выберете цвет:\n" +
                    "1. Красный\n" +
                    "2. Зеленый\n" +
                    "3. Синий\n" +
                    "4. Черный\n" +
                    "5. Белый"
        )
        enteredColor = validator.isStringValidInRange(readln(), 1..5)
    } while (enteredColor == 0)
    val colorChoice =
        when (enteredColor) {
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.BLUE
            4 -> Color.BLACK
            5 -> Color.WHITE
            else -> return null
        }


    var enteredMileage = 0
    do {
        println("Введите пробег:")
        enteredMileage = validator.isStringValidInRange(readln(), 0..5000000)
    } while (enteredMileage == 0)


    var enteredLoadCapacity: Double? = 0.0
    do {
        println("Введите грузоподъемность:")
        enteredLoadCapacity = validator.isStringValidInDouble(readln())
    } while (enteredLoadCapacity == null)


    val commercial = Commercial(
        brand = brandChoice,
        model = modelChoice,
        year = enteredYear,
        color = colorChoice,
        mileage = enteredMileage,
        loadCapacity = enteredLoadCapacity
    )

    return commercial

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