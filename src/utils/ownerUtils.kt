package utils

import data.Owner
import validators.InputValidator

fun getOwnerName(validator: InputValidator): String {
    var name: String? = ""
    do {
        println("Введите имя:")
        name = validator.isValidName(readln())
    } while (name == null)
    return name
}

fun getTelephoneNumber(validator: InputValidator): Long {
    var telephoneNumber: Long? = 0
    do {
        println("Введите${ if (telephoneNumber == null) "действительный" else ""} номер телефона:")
        telephoneNumber = validator.isTelephoneValid(readln())
    } while (telephoneNumber == null)
    return telephoneNumber
}

fun getOwnerEmail(validator: InputValidator): String {

    var email: String? = ""
    do {
        println("Введите email:")
        email = validator.isValidEmail(readln())
    } while (email == null)
    return email
}