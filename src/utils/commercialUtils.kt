package utils

import data.vehicle.*
import validators.InputValidator

fun commercialCreator(validator: InputValidator): Commercial? {
    val brandChoice = brandChoose(validator) ?: return null
    val modelChoice = modelChoose(brandChoice, validator) ?: return null
    val enteredYear = yearChoose(validator)  ?: return null
    val colorChoice = colorChoose(validator) ?: return null
    val enteredMileage = mileageChoose(validator)  ?: return null
    val enteredLoadCapacity = loadCapacityChoose(validator) ?: return null

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

private fun brandChoose(validator: InputValidator): Brand? {
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

private fun modelChoose(brandChoice: Brand?, validator: InputValidator): CommercialModel? {
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

private fun yearChoose(validator: InputValidator): Int? {
    var enteredYear: Int? = 0
    do {
        println("Введите год выпуска:")
        enteredYear = validator.isYearValid(readln())
    } while (enteredYear == 0)
    return enteredYear
}

private fun colorChoose(validator: InputValidator): Color? {
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
    val colorChoice: Color =
        when (enteredColor) {
            1 -> Color.RED
            2 -> Color.GREEN
            3 -> Color.BLUE
            4 -> Color.BLACK
            5 -> Color.WHITE
            else -> return null
        }
    return colorChoice
}

private fun mileageChoose(validator: InputValidator): Int? {
    var enteredMileage: Int? = 0
    do {
        println("Введите пробег:")
        enteredMileage = validator.isStringValidInRange(readln(), 1..5000000)
    } while (enteredMileage == 0)
    return enteredMileage
}

private fun loadCapacityChoose(validator: InputValidator): Double? {
    var enteredLoadCapacity: Double? = 0.0
    do {
        println("Введите грузоподъемность:")
        enteredLoadCapacity = validator.isStringValidInDouble(readln())
    } while (enteredLoadCapacity == null)
    return enteredLoadCapacity
}