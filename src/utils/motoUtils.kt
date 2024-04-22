package utils

import data.vehicle.*
import validators.InputValidator

fun motoConstructor(validator: InputValidator): Moto? {

    val brandChoice = brandChoose(validator) ?: return null
    val modelChoice = modelChoose(brandChoice, validator) ?: return null
    val enteredYear = yearChoose(validator) ?: return null
    val colorChoice = colorChoose(validator) ?: return null
    val enteredMileage = mileageChoose(validator)
    val typeMotoChoice = typeMotoChoose(validator) ?: return null

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

private fun brandChoose(validator: InputValidator): Brand? {
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
    return brandChoice
}

private fun modelChoose(brandChoice: Brand, validator: InputValidator): MotoModel? {
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
    return modelChoice
}

private fun yearChoose(validator: InputValidator): Int? {
    println("Введите год выпуска:")
    var enteredYear: Int? = 0
    do enteredYear = validator.isYearValid(readln())
    while (enteredYear == 0)
    return enteredYear
}

private fun colorChoose(validator: InputValidator): Color? {
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
    return colorChoice
}

private fun mileageChoose(validator: InputValidator): Int {
    println("Введите пробег:")
    var enteredMileage = 0
    do enteredMileage = validator.isStringValidInRange(readln(), 0..5000000)
    while (enteredMileage == 0)
    return enteredMileage
}

private fun typeMotoChoose(validator: InputValidator): TypeMoto? {
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
    return typeMotoChoice
}