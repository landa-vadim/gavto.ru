package validators

import java.util.regex.Pattern

class InputValidator {










    fun isValidOneToFive(number: String): Boolean {

        if (number.count() != 1) {
            println("Введите один символ в формате \"Цифра от 1 до 5\":")
            return false
        }
        val correctSymbols = listOf('1', '2', '3', '4', '5')
        if (correctSymbols.contains(number[0])) {
            when (number[0].digitToInt()) {
                1 -> {
                    return 1
                }

                2 -> {
                    return 2
                }

                3 -> {
                    return 3
                }

                4 -> {
                    return 4
                }

                5 -> {
                    return 5
                }

                else -> return 0
            }
        } else {
            print("Введите один символ в формате \"Цифра от 1 до 5\":")
            return 0
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