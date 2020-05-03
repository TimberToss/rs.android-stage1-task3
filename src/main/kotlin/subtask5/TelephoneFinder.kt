package subtask5

import kotlin.properties.Delegates

class TelephoneFinder {
    private val neighboursOfZero = arrayOf('8')
    private val neighboursOfOne = arrayOf('2', '4')
    private val neighboursOfTwo = arrayOf('1', '3', '5')
    private val neighboursOfThree = arrayOf('2', '6')
    private val neighboursOfFour = arrayOf('1', '5', '7')
    private val neighboursOfFive = arrayOf('2', '4', '6', '8')
    private val neighboursOfSix = arrayOf('3', '5', '9')
    private val neighboursOfSeven = arrayOf('4', '8')
    private val neighboursOfEight = arrayOf('5', '7', '9', '0')
    private val neighboursOfNine = arrayOf('6', '8')
    private val commonArray = arrayOf(
        neighboursOfZero,
        neighboursOfOne,
        neighboursOfTwo,
        neighboursOfThree,
        neighboursOfFour,
        neighboursOfFive,
        neighboursOfSix,
        neighboursOfSeven,
        neighboursOfEight,
        neighboursOfNine
    )
    private var originalCharArray by Delegates.notNull<CharArray>()

    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number[0] == '-') {
            return null
        }
        originalCharArray = number.toCharArray()

        return number.toCharArray()
            .mapIndexed { index, value -> checkNeighbours(index, value) }
            .flatten()
            .toTypedArray()
    }

    private fun checkNeighbours(index: Int, symbol: Char): List<String> {
        val list = mutableListOf<String>()
        val number = symbol.toString().toInt()
        for (i in commonArray[number]) {
            originalCharArray[index] = i
            list.add(String(originalCharArray))
        }
        originalCharArray[index] = symbol
        return list
    }
}
