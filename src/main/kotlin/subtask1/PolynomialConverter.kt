package subtask1

import java.lang.StringBuilder
import java.util.concurrent.CountDownLatch
import kotlin.math.absoluteValue
import kotlin.properties.Delegates
import kotlin.system.measureNanoTime

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }

        if (numbers.all { it == 0 }) {
            return "0"
        }

        val lastIndex = numbers.size - 1
        val result = StringBuilder()
        isFirstResultNumber = true

        for ((index, value) in numbers.withIndex()) {
            if (value != 0) {
                result.append(addSign(value))
                    .append(addNumber(value, index == lastIndex))
                    .append(addDegree(index, lastIndex))
            }
        }
        return result.toString()
    }

    private fun addSign(number: Int) =
        if (isFirstResultNumber) {

            isFirstResultNumber = false
            if (number < 0) {
                "-"
            } else {
                ""
            }

        } else if (number < 0) {
            " - "
        } else {
            " + "
        }

    private fun addNumber(number: Int, isLastNumber: Boolean) =
        if (number.absoluteValue == 1 && !isLastNumber) {
            ""
        } else {
            number.absoluteValue.toString()
        }

    private fun addDegree(index: Int, lastIndex: Int) =
        when (lastIndex - index) {
            0 -> ""
            1 -> "x"
            else -> "x^${lastIndex - index}"
        }

    companion object {
        private var isFirstResultNumber by Delegates.notNull<Boolean>()
    }
}