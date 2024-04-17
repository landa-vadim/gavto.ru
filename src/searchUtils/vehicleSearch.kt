package searchUtils

import data.Color
import validators.InputValidator

fun userRequestVehicleYear(validator: InputValidator): Int {
    var enteredYear: Int? = 0
    do {
        println("Введите год выпуска или цифру\"0\" для перехода к следующему параметру:")
        enteredYear = validator.isYearValidForSearch(readln())
    } while (enteredYear == null)
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

fun userRequestVehicleMileage(validator: InputValidator): Int {
    var enteredMileage: Int? = 0
    do {
        println("Введите максимальный пробег:")
        enteredMileage = validator.isStringValidInRangeForSearch(readln(), 1..5000000)
    } while (enteredMileage == null)
    return enteredMileage
}