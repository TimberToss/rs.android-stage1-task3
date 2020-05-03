package subtask3

import kotlin.properties.Delegates

class ArrayCalculator {
    private var array: Array<Int> by Delegates.notNull()
    private var mainProduct = 1
    private var secondaryProduct = 1
    private var isNumberOfNegativesOdd = false

    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        array = itemsFromArray.filterIsInstance<Int>()
            .sortedByDescending { kotlin.math.abs(it) }
            .toTypedArray()

        if (array.isEmpty()) {
            return 0
        }

        if (numberOfItems >= array.size) {
            return array.reduce(Int::times)
        }

        // TODO check zeros
        val positiveList = array.filter { it > 0 }
        val negativeList = array.filter { it < 0 }

        val sizes = positiveList.size + negativeList.size

        // zero check
        if (sizes < array.size) {
            if (sizes < numberOfItems) {
                return 0
            } else if (positiveList.isEmpty()) {
                return 0
            } else if (sizes == numberOfItems && negativeList.size % 2 == 1) {
                return 0
            }
        }
        var positiveIndex = 0
        var negativeIndex = 0

        if (positiveList.isEmpty()) {
            val reversedNegativeList = negativeList.reversed()
            repeat(numberOfItems) {
                mainProduct *= reversedNegativeList[negativeIndex++]
            }
            return mainProduct
        } else if (negativeList.isEmpty()) {
            repeat(numberOfItems) {
                mainProduct *= positiveList[positiveIndex++]
            }
            return mainProduct
        }

        var counter = 0

        while (counter + 2 <= numberOfItems) {

            if (positiveIndex + 1 == positiveList.size) {
                val times = numberOfItems - counter
                if (times % 2 == 0) {
                    repeat(times) {
                        mainProduct *= negativeList[negativeIndex++]
                        if (negativeIndex == negativeList.size) {
                            return@repeat
                        }
                    }
                } else {
                    mainProduct *= positiveList[positiveIndex]
                    repeat(times - 1) {
                        mainProduct *= negativeList[negativeIndex++]
                    }
                }
                counter = numberOfItems
                break
            }
            if (negativeIndex + 1 >= negativeList.size) {
                repeat(numberOfItems - counter) {
                    mainProduct *= positiveList[positiveIndex++]
                }
                counter = numberOfItems
                break
            }

            val positivePair = positiveList[positiveIndex] * positiveList[positiveIndex + 1]
            val negativePair = negativeList[negativeIndex] * negativeList[negativeIndex + 1]

            // TODO maybe equality of pairs can be lead to errors
            if (positivePair >= negativePair) {
                mainProduct *= positiveList[positiveIndex++]
                counter++
            } else {
                mainProduct *= negativePair
                negativeIndex += 2
                counter += 2
            }
        }

        if (counter < numberOfItems) {
            mainProduct *= positiveList[positiveIndex]
        }


//        while (counter < numberOfItems - 1) {
//
//            secondaryProduct *= array[i]
//
//            if (array[i] < 0) {
//                if (isNumberOfNegativesOdd) {
//                    mainProduct = secondaryProduct
//                    isNumberOfNegativesOdd = false
//                } else {
//                    isNumberOfNegativesOdd = true
//                }
//            } else if (array[i] > 0) {
//                mainProduct *= array[i]
//                counter++
//            }
//            i++
//        }
//
//        if (isNumberOfNegativesOdd) {
//
//        }
        return mainProduct
    }
}
