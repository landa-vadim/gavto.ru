package searchUtils

import data.*
import validators.InputValidator

fun userRequestAutoBrand(validator: InputValidator): Brand? {
    var enteredBrand = 0
    do {
        println(
            "Выберете марку:\n" +
                    "1. Audi\n" +
                    "2. BMW\n" +
                    "3. Mazda\n" +
                    "4. KIA\n" +
                    "5. Skoda\n" +
                    "6. Следующий параметр"
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

fun userRequestAutoModel(brandChoice: Brand?, validator: InputValidator): AutoModel? {
    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.AUDI -> println(
                "Выберете модель:\n+" +
                        "1. A3\n" +
                        "2. A4\n" +
                        "3. A6\n" +
                        "4. Q3\n" +
                        "5. Q5\n" +
                        "6. Следующий параметр"
            )

            Brand.BMW -> println(
                "Выберете модель:\n" +
                        "1. M3\n" +
                        "2. M5\n" +
                        "3. M7\n" +
                        "4. X5\n" +
                        "5. X6\n" +
                        "6. Следующий параметр"
            )

            Brand.MAZDA -> println(
                "Выберете модель:\n" +
                        "1. M3\n" +
                        "2. M6\n" +
                        "3. CX-30\n" +
                        "4. CX-5\n" +
                        "5. CX-9\n" +
                        "6. Следующий параметр"
            )

            Brand.KIA -> println(
                "Выберете модель:\n" +
                        "1. Rio\n" +
                        "2. Cerato\n" +
                        "3. Optima\n" +
                        "4. Sportage\n" +
                        "5. Sorento\n" +
                        "6. Следующий параметр"
            )

            Brand.SKODA -> println(
                "Выберете модель:\n" +
                        "1. Rapid\n" +
                        "2. Octavia\n" +
                        "3. Superb\n" +
                        "4. Karoq\n" +
                        "5. Kodiaq\n" +
                        "6. Следующий параметр"
            )

            else -> return null
        }
        enteredModel = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredModel == 0)
    return if (enteredModel == 6) null
    else when (brandChoice) {
        Brand.AUDI -> AudiAutoModel(AudiAutoModels.getById(enteredModel - 1))
        Brand.BMW -> BmwAutoModel(BmwAutoModels.getById(enteredModel - 1))
        Brand.MAZDA -> MazdaAutoModel(MazdaAutoModels.getById(enteredModel - 1))
        Brand.KIA -> KiaAutoModel(KiaAutoModels.getById(enteredModel - 1))
        Brand.SKODA -> SkodaAutoModel(SkodaAutoModels.getById(enteredModel - 1))
        else -> null
    }
}