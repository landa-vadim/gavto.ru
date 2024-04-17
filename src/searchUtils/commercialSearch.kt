package searchUtils

import data.*
import validators.InputValidator

fun brandChoose(validator: InputValidator): Brand? {
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
    return brandChoice
}

fun modelChoose(brandChoice: Brand?, validator: InputValidator): CommercialModel? {
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
    return modelChoice
}

fun loadCapacityChoose(validator: InputValidator): Double? {
    var enteredLoadCapacity: Double? = 0.0
    do {
        println("Введите грузоподъемность:")
        enteredLoadCapacity = validator.isStringValidInDouble(readln())
    } while (enteredLoadCapacity == null)
    return enteredLoadCapacity
}