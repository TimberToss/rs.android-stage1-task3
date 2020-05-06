package subtask5


class TelephoneFinder {

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {

        val originalCharArray = number.toCharArray()
        val result = mutableListOf<String>()

        for ((index, value) in number.toCharArray().withIndex()) {

            val neighboursArray = neighbours[value] ?: return null

            for (neighbour in neighboursArray) {
                originalCharArray[index] = neighbour
                result.add(String(originalCharArray))
            }

            originalCharArray[index] = value
        }

        return result.toTypedArray()
    }

    companion object {
        private val neighbours = mapOf(
            '0' to arrayOf('8'),
            '1' to arrayOf('2', '4'),
            '2' to arrayOf('1', '3', '5'),
            '3' to arrayOf('2', '6'),
            '4' to arrayOf('1', '5', '7'),
            '5' to arrayOf('2', '4', '6', '8'),
            '6' to arrayOf('3', '5', '9'),
            '7' to arrayOf('4', '8'),
            '8' to arrayOf('5', '7', '9', '0'),
            '9' to arrayOf('6', '8')
        )
    }
}