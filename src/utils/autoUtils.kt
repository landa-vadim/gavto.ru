package utils

import data.*
import validators.InputValidator

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