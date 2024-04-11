package validators

import java.util.regex.Pattern

class InputValidator() {

    fun isValidEmail(email: String): Boolean {

        val pattern = Pattern.compile(
            "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\\\.[A-Za-z]{2,6}\\\$"
        )
        val matcher = pattern.matcher(email)
        return matcher.matches()
    }




}