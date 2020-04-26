package portfolio.shiikharshah.utils

import android.util.Patterns


object StringUtils {
    const val EMPTY_STRING = ""
    const val SPACE_STRING = " "
    const val COLON = " : "
    const val DATE_SEPARATOR = "/"
    const val TIME_SEPARATOR = ":"
    const val COMMA = ","
    const val PERCENTAGE = "%"
    const val NULL_STRING = "null"
    private const val MAX_VALID_DIGITS_PHONE = 15
    private const val MIN_VALID_DIGITS_PHONE = 10
    private const val MAX_VALID_AGE = 90
    private const val MIN_VALID_AGE = 18

    /**
     * Checks if string is empty or not
     * @param value string to check
     * @return true if empty or null, false otherwise
     */
    fun isEmpty(value: String?): Boolean {
        var value = value
        try {
            value = value!!.trim { it <= ' ' }
        } catch (e: Exception) {
        }
        return value == null || value.length == 0
    }

    /**
     * Checks if string is valid and having at least minimum number of characters or not
     *
     * @param value string to check
     * @param min   minimum length of validity
     * @return true if valid, false otherwise
     */
    fun isValid(value: String?, min: Int): Boolean {
        var value = value
        try {
            value = value!!.trim { it <= ' ' }
        } catch (e: Exception) {
        }
        return value != null && value.length >= min
    }

    /**
     * Checks if string is valid or not
     *
     * @param value string to check
     * @return true if valid, false otherwise
     */
    fun isValid(value: String): Boolean {
        return !isEmpty(value) && !value.equals(
            EMPTY_STRING,
            ignoreCase = true
        ) && !value.equals(NULL_STRING, ignoreCase = true)
    }

    /**
     * Checks if email id is in valid format or not
     *
     * @param emailId email id to check
     * @return true if valid, false otherwise
     */
    fun isValidEmail(emailId: String): Boolean {
        if (!isValid(emailId)) {
            return false
        }
        val pattern = Patterns.EMAIL_ADDRESS
        return pattern.matcher(emailId).matches()
    }

    /**
     * Checks if phone number is in valid format and not having max digits
     *
     * @param phone phone number to check
     * @return true if valid, false otherwise
     */
    fun isValidPhone(phone: String?): Boolean {
        var phone = phone
        try {
            phone = phone!!.trim { it <= ' ' }
        } catch (e: Exception) {
        }
        return phone != null && isValid(phone) && phone.length <= MAX_VALID_DIGITS_PHONE && phone.length >= MIN_VALID_DIGITS_PHONE
    }

    fun equals(s1: String, s2: String): Boolean {
        return isValid(s1) && isValid(s2) && s1 == s2
    }

    fun formatDate(day: Int, month: Int, year: Int): String {
        return String.format(
            "%02d$DATE_SEPARATOR%02d$DATE_SEPARATOR%02d",
            month, day, year
        )
    }

    fun formatTime(hour: Int, minute: Int, second: Int): String {
        return String.format("%02d$TIME_SEPARATOR%02d", hour, minute)
    }

    fun trimLastComma(str: String?): String? {
        var str = str
        if (str != null && str.length >= 2 && str[str.length - 1] == ',') {
            str = str.substring(0, str.length - 1)
        }
        return str
    }

    fun isValidAge(age: String?): Boolean {
        var age = age
        try {
            age = age!!.trim { it <= ' ' }
        } catch (e: Exception) {
        }
        return age != null && isValid(age) && age.toInt() <= MAX_VALID_AGE && age.toInt() >= MIN_VALID_AGE
    }
}