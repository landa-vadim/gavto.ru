package searchUtils

import data.*
import validators.InputValidator

fun userRequestMotoBrand(validator: InputValidator): Brand? {
    println(
        "Выберете марку:\n" +
                "1. BMW\n" +
                "2. Yamaha\n" +
                "3. Kawasaki\n" +
                "4. Ural\n" +
                "5. Honda\n" +
                "6. Следующий параметр"
    )
    var enteredBrand = 0
    do enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    while (enteredBrand == 0)
    return when (enteredBrand) {
        1 -> Brand.BMW
        2 -> Brand.YAMAHA
        3 -> Brand.KAWASAKI
        4 -> Brand.URAL
        5 -> Brand.HONDA
        else -> return null
    }
}

fun userRequestMotoModel(brandChoice: Brand, validator: InputValidator): MotoModel? {
    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.BMW -> println(
                "Выберете модель:\n+" +
                        "1. M\n" +
                        "2. K\n" +
                        "3. G\n" +
                        "4. R\n" +
                        "5. C\n" +
                        "6. Следующий параметр"
            )

            Brand.YAMAHA -> println(
                "Выберете модель:\n" +
                        "1. MT\n" +
                        "2. XSR\n" +
                        "3. XT\n" +
                        "4. XV\n" +
                        "5. YZF\n" +
                        "6. Следующий параметр"
            )

            Brand.KAWASAKI -> println(
                "Выберете модель:\n" +
                        "1. EN\n" +
                        "2. ER\n" +
                        "3. KX\n" +
                        "4. NINJA,\n" +
                        "5. Z\n" +
                        "6. Следующий параметр"
            )

            Brand.URAL -> println(
                "Выберете модель:\n" +
                        "1. M\n" +
                        "2. Solo\n" +
                        "3. Tourist\n" +
                        "4. Voyazh\n" +
                        "5. Wolf\n" +
                        "6. Следующий параметр"
            )

            Brand.HONDA -> println(
                "Выберете модель:\n" +
                        "1. CB\n" +
                        "2. CBF\n" +
                        "3. CBR\n" +
                        "4. CRF\n" +
                        "5. GL\n" +
                        "6. Следующий параметр"
            )

            else -> return null
        }
        enteredModel = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredModel == 0)
    return when (brandChoice) {
        Brand.BMW -> BmwMotoModel(BmwMotoModels.getById(enteredModel - 1))
        Brand.YAMAHA -> YamahaMotoModel(YamahaMotoModels.getById(enteredModel - 1))
        Brand.KAWASAKI -> KawasakiMotoModel(KawasakiMotoModels.getById(enteredModel - 1))
        Brand.URAL -> UralMotoModel(UralMotoModels.getById(enteredModel - 1))
        Brand.HONDA -> HondaMotoModel(HondaMotoModels.getById(enteredModel - 1))
        else -> return null
    }
}

fun userRequestMotoType(validator: InputValidator): TypeMoto? {
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
        1 -> TypeMoto.CROSS
        2 -> TypeMoto.SPORT
        3 -> TypeMoto.GRANTURISMO
        else -> return null
    }
}