package validators


import java.util.*
import java.util.regex.Pattern

class InputValidator {

    val calendar: Calendar = Calendar.getInstance()


    fun isStringValidInRange(string: String, range: IntRange): Int {
        val output = string.toIntOrNull()
        return if (output != null && output in range) output else {
            println("Введите цифру от ${range.first} до ${range.last}:")
            0
        }
    }

    fun isStringValidInRangeForSearch(string: String, range: IntRange): Int? {
        val output = string.toIntOrNull()
        return if (output != null && (output in range || output == 0)) output
        else {
            println("Введите цифру от ${range.first} до ${range.last} или цифру \"0\" для перехода к следующему параметру:")
            null
        }
    }

    fun isStringValidInDouble(string: String): Double? {
        val output = string.toDoubleOrNull()
        return output
    }

    fun isYearValid(string: String): Int {
        val output = string.toIntOrNull()
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        return if (output != null && output in 1900..year) output
        else {
            println("Введите год в формате \"ГГГГ\"")
            0
        }
    }

    fun isYearValidForSearch(string: String): Int? {
        val output = string.toIntOrNull()
        val calendar: Calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        return if (output != null && (output in 1900..year || output == 0)) output
        else {
            println("Введите год в формате \"ГГГГ\" или цифру \"0\" для перехода к следующему параметру")
            return null
        }
    }

    fun isValidEmail(email: String): Boolean {

        val pattern = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}\\\$"
        )
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }


}