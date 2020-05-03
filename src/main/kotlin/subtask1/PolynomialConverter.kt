package subtask1

import java.lang.StringBuilder
import kotlin.properties.Delegates

class PolynomialConverter {

    private var lastIndex by Delegates.notNull<Int>()

    fun convertToStringFrom(numbers: Array<Number>): String? {
        if (numbers.isEmpty()) {
            return null
        }

        lastIndex = numbers.size - 1
        return numbers.mapIndexed { index, value -> valueToString(index, value) }
            .filter { it != ZERO }
            .joinToString(separator = " ")
    }

    private fun valueToString(index: Int, value: Number) =
        if (value.toDouble() != 0.0) {
            StringBuilder()
                .append(addSign(value, index == 0))
                .append(addDegree(index))
                .toString()
        } else {
            ZERO
        }

    private fun addSign(number: Number, isFirstNumber: Boolean) =
        if (number.toDouble() < 0.0) {
            val string = deleteDigitOne(number.toString().substring(1, number.toString().length))
            "- $string"
        } else if (number.toDouble() > 0.0 && !isFirstNumber) {
            "+ ${deleteDigitOne(number.toString())}"
        } else {
            deleteDigitOne(number.toString())
        }

    private fun addDegree(index: Int): String =
        when (lastIndex - index) {
            0 -> ""
            1 -> "x"
            else -> "x^${lastIndex - index}"
        }

    private fun deleteDigitOne(string: String) =
        if (string == "1" || string == "1.0") {
            ""
        } else {
            string
        }


    companion object {
        private const val ZERO = "0.0"
    }
}
