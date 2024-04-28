package utils

import data.Owner
import validators.InputValidator

val validator = InputValidator()
fun getOwnerName(): String {
    var name: String? = ""
    do {
        println("Введите имя:")
        name = validator.isValidName(readln())
    } while (name == null)
    return name
}

fun getTelephoneNumber(): Long {
    var telephoneNumber: Long? = 0
    println("Введите номер телефона:")
    do {
        println("Введите действительный номер телефона:")
        telephoneNumber = validator.isTelephoneValid(readln())
    } while (telephoneNumber == null)
    return telephoneNumber
}

fun getOwnerEmail(): String {

    var email: String? = ""
    do {
        println("Введите email:")
        email = validator.isValidEmail(readln())
    } while (email == null)
    return email
}