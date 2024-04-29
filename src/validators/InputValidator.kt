package validators


import java.util.*
import java.util.regex.Pattern

class InputValidator {
    val calendar: Calendar = Calendar.getInstance()
    fun isStringValidInRange(string: String, range: IntRange): Int {
        val output = string.toIntOrNull()
        return if (output != null && output in range) {
            output
        } else {
            println("Введите число от ${range.first} до ${range.last}:")
            0
        }
    }

    fun isStringValidInRangeNullable(string: String, range: IntRange): Int? {
        val output = string.toIntOrNull()
        if (output != null && output in range) {
            return output
        }
        return if (output == 0) {
            null
        } else {
            println("Введите число от ${range.first} до ${range.last}:")
            0
        }
    }

    fun isStringValidInDouble(string: String): Double? {
        val output = string.toDoubleOrNull()
        return if (output != 0.0) output else null
    }

    fun isYearValid(string: String): Int? {
        val output = string.toIntOrNull()
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        if (output != null && (output in 1900..year)) return output
        return if (output == 0) null
        else 0
    }

    fun isValidEmail(email: String): String? {
        val pattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+[.][A-Za-z]{2,3}$"
        val isEmailValid = Regex(pattern).matches(email)
        return if (isEmailValid) email else null
    }

    fun isTelephoneValid(string: String): Long? {
        val output = string.toLongOrNull()
        return output
    }

    fun isValidName(string: String): String? {
        val pattern = "^[a-zA-Zа-яА-Я-\\s]*$"
        val isStringValid = Regex(pattern).matches(string)
        return if (isStringValid) string else null
    }

}