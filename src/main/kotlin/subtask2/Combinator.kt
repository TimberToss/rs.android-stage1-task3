package subtask2

class Combinator {

    fun checkChooseFromArray(array: Array<Int>): Int? {
        val elementsNumber = array[1]
        val remainder = factorialOf(elementsNumber) / array[0]
        var currentFactorial = 1

        for (k in 1..elementsNumber / 2) {
            currentFactorial *= k
            if (remainder == currentFactorial * factorialOf(elementsNumber - k)) {
                return k
            }
        }

        return null
    }

    private fun factorialOf(number: Int): Long {
        if (number <= 1L) {
            return 1L
        }
        var result: Long = 1
        for (i in 1..number) {
            result *= i
        }
        return result
    }
}
