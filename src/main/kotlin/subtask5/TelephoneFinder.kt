package subtask5


class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number[0] == '-') {
            return null
        }
        val originalCharArray = number.toCharArray()

        return number.toCharArray()
            .mapIndexed { index, value -> checkNeighbours(index, value, originalCharArray) }
            .flatten()
            .toTypedArray()
    }

    private fun checkNeighbours(
        index: Int,
        symbol: Char,
        originalCharArray: CharArray
    ): List<String> {

        val list = mutableListOf<String>()
        val number = Character.getNumericValue(symbol)

        for (i in neighbours[number]) {
            originalCharArray[index] = i
            list.add(String(originalCharArray))
        }

        originalCharArray[index] = symbol
        return list
    }

    companion object {
        private val neighbours = arrayOf(
            arrayOf('8'),
            arrayOf('2', '4'),
            arrayOf('1', '3', '5'),
            arrayOf('2', '6'),
            arrayOf('1', '5', '7'),
            arrayOf('2', '4', '6', '8'),
            arrayOf('3', '5', '9'),
            arrayOf('4', '8'),
            arrayOf('5', '7', '9', '0'),
            arrayOf('6', '8')
        )
    }
}