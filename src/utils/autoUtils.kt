package utils

import data.vehicle.*
import validators.InputValidator

fun autoConstructor(validator: InputValidator): Auto? {
    val brand = chooseCarBrand(validator) ?: return null
    val model = chooseCarModel(brand, validator) ?: return null
    val year = chooseYear(validator) ?: return null
    val color = chooseColor(validator) ?: return null
    val mileage = chooseMileage(validator) ?: return null
    val carType = chooseCarType(validator) ?: return null

    return Auto(
        brand = brand,
        model = model,
        year = year,
        color = color,
        mileage = mileage,
        typeAuto = carType
    )
}

fun chooseCarBrand(validator: InputValidator): Brand? {
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
    return when (enteredBrand) {
        1 -> Brand.AUDI
        2 -> Brand.BMW
        3 -> Brand.MAZDA
        4 -> Brand.KIA
        5 -> Brand.SKODA
        else -> return null
    }
}

fun chooseCarModel(brandChoice: Brand, validator: InputValidator): AutoModel? {
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
    return when (brandChoice) {
        Brand.AUDI -> AudiAutoModel(AudiAutoModels.getById(enteredModel - 1))
        Brand.BMW -> BmwAutoModel(BmwAutoModels.getById(enteredModel - 1))
        Brand.MAZDA -> MazdaAutoModel(MazdaAutoModels.getById(enteredModel - 1))
        Brand.KIA -> KiaAutoModel(KiaAutoModels.getById(enteredModel - 1))
        Brand.SKODA -> SkodaAutoModel(SkodaAutoModels.getById(enteredModel - 1))
        else -> null
    }
}

fun chooseYear(validator: InputValidator): Int? {
    var enteredYear: Int? = 0
    do {
        println("Введите год выпуска:")
        enteredYear = validator.isYearValid(readln())
    } while (enteredYear == 0)
    return enteredYear
}

fun chooseColor(validator: InputValidator): Color? {
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
    return when (enteredColor) {
        1 -> Color.RED
        2 -> Color.GREEN
        3 -> Color.BLUE
        4 -> Color.BLACK
        5 -> Color.WHITE
        else -> return null
    }
}

fun chooseMileage(validator: InputValidator): Int? {
    var enteredMileage: Int? = 0
    do {
        println("Введите пробег:")
        enteredMileage = validator.isStringValidInRangeNullable(readln(), 1..5000000)
    } while (enteredMileage == 0)
    return enteredMileage
}

fun chooseCarType(validator: InputValidator): TypeAuto? {
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
    return when (enteredTypeAuto) {
        1 -> TypeAuto.SEDAN
        2 -> TypeAuto.HATCHBACK
        3 -> TypeAuto.UNIVERSAL
        else -> return null
    }
}