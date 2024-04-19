package searchUtils

import data.*
import validators.InputValidator

fun userRequestCommercialBrand(validator: InputValidator): Brand? {
    var enteredBrand = 0
    do {
        println(
            "Выберете марку:\n" +
                    "1. Citroen\n" +
                    "2. Lada\n" +
                    "3. Peugeot\n" +
                    "4. Renault\n" +
                    "5. VolksWagen\n" +
                    "6. Следующий параметр"
        )
        enteredBrand = validator.isStringValidInRange(readln(), 1..6)
    } while (enteredBrand == 0)
        return when (enteredBrand) {
            1 -> Brand.CITROEN
            2 -> Brand.LADA
            3 -> Brand.PEUGEOT
            4 -> Brand.RENAULT
            5 -> Brand.VOLKSWAGEN
            else -> return null
        }
}

fun userRequestModel(brandChoice: Brand?, validator: InputValidator): CommercialModel? {
    var enteredModel = 0
    do {
        when (brandChoice) {
            Brand.CITROEN -> println(
                "Выберете модель:\n+" +
                        "1. Berlingo\n" +
                        "2. Следующий параметр"
            )

            Brand.LADA -> println(
                "Выберете модель:\n" +
                        "1. Largus\n" +
                        "2. Следующий параметр"
            )

            Brand.PEUGEOT -> println(
                "Выберете модель:\n" +
                        "1. Partner\n" +
                        "2. Следующий параметр"
            )

            Brand.RENAULT -> println(
                "Выберете модель:\n" +
                        "1. Dokker\n" +
                        "2. Следующий параметр"
            )

            Brand.VOLKSWAGEN -> println(
                "Выберете модель:\n" +
                        "1. Caddy\n" +
                        "2. Следующий параметр"
            )

            else -> return null
        }
        enteredModel = validator.isStringValidInRange(readln(), 1..2)
    } while (enteredModel == 0)
    return if (enteredModel == 2) null
    else when (brandChoice) {
        Brand.CITROEN -> CitroenCommercialModel(CitroenCommercialModels.getById(enteredModel - 1))
        Brand.LADA -> LadaCommercialModel(LadaCommercialModels.getById(enteredModel - 1))
        Brand.PEUGEOT -> PeugeotCommercialModel(PeugeotCommercialModels.getById(enteredModel - 1))
        Brand.RENAULT -> RenaultCommercialModel(RenaultCommercialModels.getById(enteredModel - 1))
        Brand.VOLKSWAGEN -> VolksWagenCommercialModel(VolksWagenCommercialModels.getById(enteredModel - 1))
        else -> return null
    }
}

fun userRequestLoadCapacity(validator: InputValidator): Double? {
    println("Введите грузоподъемность или введите любую букву для перехода к следующему параметру:")
    return validator.isStringValidInDouble(readln())
}