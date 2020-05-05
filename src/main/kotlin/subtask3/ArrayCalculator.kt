package subtask3

import kotlin.math.absoluteValue
import kotlin.properties.Delegates

class ArrayCalculator {

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        val intList = itemsFromArray.filterIsInstance<Int>().sortedByDescending { it.absoluteValue }

        if (intList.isEmpty()) {
            return 0
        }

        if (numberOfItems >= intList.size) {
            return intList.reduce(Int::times)
        }

        positiveList = intList.filter { it > 0 }
        negativeList = intList.filter { it < 0 }

        if (zeroCheck(intList, numberOfItems)) {
            return 0
        }

        positiveIndex = 0
        negativeIndex = 0
        product = 1

        if (positiveList.isEmpty() && numberOfItems % 2 == 1) {
            return negativeList.takeLast(numberOfItems).reduce(Int::times)
        }

        counter = 0

        while (counter <= numberOfItems - 1) {

            if (positiveIndex >= positiveList.size - 1) {
                checkPositive(numberOfItems)
                break
            }

            if (negativeIndex >= negativeList.size - 1) {
                checkNegative(numberOfItems)
                break
            }

            val positivePair = positiveList[positiveIndex] * positiveList[positiveIndex + 1]
            val negativePair = negativeList[negativeIndex] * negativeList[negativeIndex + 1]

            if (positivePair >= negativePair) {
                product *= positiveList[positiveIndex++]
                counter++

            } else {
                product *= negativePair
                negativeIndex += 2
                counter += 2
            }
        }

        if (counter < numberOfItems) {
            product *= positiveList[positiveIndex]
        }

        return product
    }

    private fun checkPositive(numberOfItems: Int) {
        var times = numberOfItems - counter
        counter = numberOfItems

        if (times % 2 != 0) {
            product *= positiveList[positiveIndex]
            times--
        }
        if (times != 0) {
            product *= negativeList.subList(negativeIndex, negativeIndex + times).reduce(Int::times)
        }
    }

    private fun checkNegative(numberOfItems: Int) {
        if (numberOfItems != counter) {
            product *= positiveList.subList(positiveIndex, positiveIndex + numberOfItems - counter)
                .reduce(Int::times)
        }
        counter = numberOfItems
    }

    private fun zeroCheck(intList: List<Int>, numberOfItems: Int): Boolean {
        val sizes = positiveList.size + negativeList.size

        if (sizes < intList.size) {                                         // check if zeros exist

            if (sizes < numberOfItems                                       // we must to put zero
                || positiveList.isEmpty() && numberOfItems % 2 == 1         // 0 > odd multiply of negatives
                || sizes == numberOfItems && negativeList.size % 2 == 1     // 0 > odd multiply of negatives
            ) {
                return true
            }
        }
        return false
    }

    companion object {
        private lateinit var positiveList: List<Int>
        private lateinit var negativeList: List<Int>
        private var positiveIndex by Delegates.notNull<Int>()
        private var negativeIndex by Delegates.notNull<Int>()
        private var product by Delegates.notNull<Int>()
        private var counter by Delegates.notNull<Int>()
    }
}