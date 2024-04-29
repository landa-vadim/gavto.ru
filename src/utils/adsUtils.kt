package utils

import validators.InputValidator
import java.util.*

fun getAdDate(): Date {
    val date = Date()
    return date
}

fun getAdPrice(validator: InputValidator): Int {
    var price = 0
    do {
        println("Введите цену:")
        price = validator.isStringValidInRange(readln(), 1..99999999)
    } while (price == 0)
    return price
}