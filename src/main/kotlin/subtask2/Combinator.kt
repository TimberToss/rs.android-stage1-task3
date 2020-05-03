package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Number>): Number? {
        val elementsNumber: Long = array[1].toLong()
        val remainder: Long = factorialOf(elementsNumber) / array[0].toLong()
        val limit: Long = elementsNumber / 2
        var currentNumber: Long = 1
        var currentFactorial: Long = 1
        var denominator: Long = factorialOf(elementsNumber - currentNumber)

        while (remainder != denominator && currentNumber <= limit) {
            currentNumber++
            currentFactorial *= currentNumber
            denominator = currentFactorial * factorialOf(elementsNumber - currentNumber)
        }

        return if (remainder == denominator) {
            currentNumber.toInt()
        } else {
            null
        }
    }

    private fun factorialOf(number: Long): Long {
        if (number == 0L) {
            return 1
        }
        var result: Long = 1
        for (i in 1..number) {
            result *= i
        }
        return result
    }
}
