package searchUtils

import data.vehicle.*
import validators.InputValidator

fun userRequestVehicleBrand(validator: InputValidator): Brand? {
    var enteredBrand = 0
    do {
        println(
            "Выберете марку:\n" +
                    "1. Audi\n" +
                    "2. BMW\n" +
                    "3. Mazda\n" +
                    "4. KIA\n" +
                    "5. Skoda\n" +
                    "6. Yamaha\n" +
                    "7. Kawasaki\n" +
                    "8. Ural\n" +
                    "9. Honda\n" +
                    "10. Citroen\n" +
                    "11. Lada\n" +
                    "12. Peugeot\n" +
                    "13. Renault\n" +
                    "14. Volksvagen\n" +
                    "15. Следующий параметр"
        )
        enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredBrand == 0)
    return when (enteredBrand) {
        1 -> Brand.AUDI
        2 -> Brand.BMW
        3 -> Brand.MAZDA
        4 -> Brand.KIA
        5 -> Brand.SKODA
        6 -> Brand.YAMAHA
        7 -> Brand.KAWASAKI
        8 -> Brand.URAL
        9 -> Brand.HONDA
        10 -> Brand.CITROEN
        11 -> Brand.LADA
        12 -> Brand.PEUGEOT
        13 -> Brand.RENAULT
        14 -> Brand.VOLKSWAGEN
        else -> return null
    }
}

fun userRequestVehicleModel(brandChoice: Brand?, validator: InputValidator): VehicleModel? {
    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.AUDI -> {
                println(
                    "Выберете модель:\n+" +
                            "1. A3\n" +
                            "2. A4\n" +
                            "3. A6\n" +
                            "4. Q3\n" +
                            "5. Q5\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.BMW -> {
                println(
                    "Выберете модель:\n" +
                            "1. M3\n" +
                            "2. M5\n" +
                            "3. M7\n" +
                            "4. X5\n" +
                            "5. X6\n" +
                            "6. M\n" +
                            "7. K\n" +
                            "8. G\n" +
                            "9. R\n" +
                            "10. C\n" +
                            "11. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..11)
            }

            Brand.MAZDA -> {
                println(
                    "Выберете модель:\n" +
                            "1. M3\n" +
                            "2. M6\n" +
                            "3. CX-30\n" +
                            "4. CX-5\n" +
                            "5. CX-9\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.KIA -> {
                println(
                    "Выберете модель:\n" +
                            "1. Rio\n" +
                            "2. Cerato\n" +
                            "3. Optima\n" +
                            "4. Sportage\n" +
                            "5. Sorento\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.SKODA -> {
                println(
                    "Выберете модель:\n" +
                            "1. Rapid\n" +
                            "2. Octavia\n" +
                            "3. Superb\n" +
                            "4. Karoq\n" +
                            "5. Kodiaq\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.YAMAHA -> {
                println(
                    "Выберете модель:\n" +
                            "1. MT\n" +
                            "2. XSR\n" +
                            "3. XT\n" +
                            "4. XV\n" +
                            "5. YZF\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.KAWASAKI -> {
                println(
                    "Выберете модель:\n" +
                            "1. EN\n" +
                            "2. ER\n" +
                            "3. KX\n" +
                            "4. NINJA,\n" +
                            "5. Z\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.URAL -> {
                println(
                    "Выберете модель:\n" +
                            "1. M\n" +
                            "2. Solo\n" +
                            "3. Tourist\n" +
                            "4. Voyazh\n" +
                            "5. Wolf\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.HONDA -> {
                println(
                    "Выберете модель:\n" +
                            "1. CB\n" +
                            "2. CBF\n" +
                            "3. CBR\n" +
                            "4. CRF\n" +
                            "5. GL\n" +
                            "6. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..6)
            }

            Brand.CITROEN -> {
                println(
                    "Выберете модель:\n+" +
                            "1. Berlingo\n" +
                            "2. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..2)
            }

            Brand.LADA -> {
                println(
                    "Выберете модель:\n" +
                            "1. Largus\n" +
                            "2. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..2)
            }

            Brand.PEUGEOT -> {
                println(
                    "Выберете модель:\n" +
                            "1. Partner\n" +
                            "2. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..2)
            }

            Brand.RENAULT -> {
                println(
                    "Выберете модель:\n" +
                            "1. Dokker\n" +
                            "2. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..2)
            }

            Brand.VOLKSWAGEN -> {
                println(
                    "Выберете модель:\n" +
                            "1. Caddy\n" +
                            "2. Следующий параметр"
                )
                enteredModel = validator.isStringValidInRange(readln(), 1..2)
            }

            else -> return null
        }
    } while (enteredModel == 0)
    return if (enteredModel == 6) null
    else when (brandChoice) {
        Brand.AUDI -> AudiAutoModel(AudiAutoModels.getById(enteredModel - 1))
        Brand.BMW -> if (enteredModel in 1..5) BmwAutoModel(BmwAutoModels.getById(enteredModel - 1)) else BmwMotoModel(
            BmwMotoModels.getById(enteredModel - 6)
        )

        Brand.MAZDA -> MazdaAutoModel(MazdaAutoModels.getById(enteredModel - 1))
        Brand.KIA -> KiaAutoModel(KiaAutoModels.getById(enteredModel - 1))
        Brand.SKODA -> SkodaAutoModel(SkodaAutoModels.getById(enteredModel - 1))
        Brand.YAMAHA -> YamahaMotoModel(YamahaMotoModels.getById(enteredModel - 1))
        Brand.KAWASAKI -> KawasakiMotoModel(KawasakiMotoModels.getById(enteredModel - 1))
        Brand.URAL -> UralMotoModel(UralMotoModels.getById(enteredModel - 1))
        Brand.HONDA -> HondaMotoModel(HondaMotoModels.getById(enteredModel - 1))
        Brand.CITROEN -> CitroenCommercialModel(CitroenCommercialModels.getById(enteredModel - 1))
        Brand.LADA -> LadaCommercialModel(LadaCommercialModels.getById(enteredModel - 1))
        Brand.PEUGEOT -> PeugeotCommercialModel(PeugeotCommercialModels.getById(enteredModel - 1))
        Brand.RENAULT -> RenaultCommercialModel(RenaultCommercialModels.getById(enteredModel - 1))
        Brand.VOLKSWAGEN -> VolksWagenCommercialModel(VolksWagenCommercialModels.getById(enteredModel - 1))
        else -> return null
    }
}

fun userRequestVehicleYear(validator: InputValidator): Int? {
    var enteredYear: Int? = 0
    do {
        println("Введите самый ранний год выпуска или цифру\"0\" для перехода к следующему параметру:")
        enteredYear = validator.isYearValid(readln())
    } while (enteredYear == 0)
    return enteredYear
}

fun userRequestVehicleColor(validator: InputValidator): Color? {
    var enteredColor = 0
    do {
        println(
            "Выберете цвет:\n" +
                    "1. Красный\n" +
                    "2. Зеленый\n" +
                    "3. Синий\n" +
                    "4. Черный\n" +
                    "5. Белый\n" +
                    "6. Следующий параметр"
        )
        enteredColor = validator.isStringValidInRange(readln(), 1..6)
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

fun userRequestVehicleMileage(validator: InputValidator): IntRange {
    var enteredMileage = 0..5000000
    var enteredMinMileage: Int?
    var enteredMaxMileage: Int?
    do {
        println("Введите минимальный пробег или цифру \"0\" для перехода к следующему параметру:")
        enteredMinMileage = validator.isStringValidInRangeNullable(readln(), 1..5000000)
    } while (enteredMinMileage == 0)
    enteredMinMileage = enteredMinMileage ?: 1
    do {
        println("Введите максимальный пробег или цифру \"0\" для перехода к следующему параметру:")
        enteredMaxMileage = validator.isStringValidInRangeNullable(readln(), enteredMinMileage..5000000)
    } while (enteredMaxMileage == 0)
    enteredMaxMileage = enteredMaxMileage ?: 5000000
    enteredMileage = enteredMinMileage..enteredMaxMileage
    return enteredMileage
}

fun userRequestSpecificInfo(chooseOption: Int, validator: InputValidator): String? {
    if (chooseOption == 2) {
        var enteredTypeAuto = 0
        do {
            println(
                "Выберете тип кузова:\n" +
                        "1. Седан\n" +
                        "2. Хэтчбэк\n" +
                        "3. Универсал\n" +
                        "4. Следующий параметр"
            )
            enteredTypeAuto = validator.isStringValidInRange(readln(), 1..4)
        } while (enteredTypeAuto == 0)
        return when (enteredTypeAuto) {
            1 -> "${TypeAuto.SEDAN}"
            2 -> "${TypeAuto.HATCHBACK}"
            3 -> "${TypeAuto.UNIVERSAL}"
            else -> return null
        }
    }
    if (chooseOption == 3) {
        var enteredTypeMoto = 0
        do {
            println(
                "Выберете тип мотоцикла:\n" +
                        "1. Кроссовый\n" +
                        "2. Спортивный\n" +
                        "3. Грантуризмо\n" +
                        "4. Следующий параметр"
            )
            enteredTypeMoto = validator.isStringValidInRange(readln(), 1..4)
        } while (enteredTypeMoto == 0)
        return when (enteredTypeMoto) {
            1 -> "${TypeMoto.CROSS}"
            2 -> "${TypeMoto.SPORT}"
            3 -> "${TypeMoto.GRANTURISMO}"
            else -> return null
        }
    }
    if (chooseOption == 4) {
        println("Введите минимальную грузоподъемность или \"0.0\" для перехода к следующему параметру:")
        return "${validator.isStringValidInDouble(readln())}"
    } else return null
}

