package subtask4


class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val originalNumber = number.toLong()
        return recursiveDecompose(
            originalNumber,
            originalNumber * originalNumber,
            originalNumber
        )?.map { it.toInt() }?.toTypedArray()
    }

    private fun recursiveDecompose(
        currentNumber: Long,
        remainder: Long,
        originalNumber: Long
    ): MutableList<Long>? {

        var result: MutableList<Long>? = null

        if (remainder != 0L) {
            for (i in currentNumber - 1 downTo 1) {
                val nextRemainder = remainder - i * i

                if (nextRemainder >= 0) {
                    result = recursiveDecompose(i, nextRemainder, originalNumber)

                    if (result != null) {
                        if (currentNumber != originalNumber) {
                            result.add(currentNumber)
                        }
                        break
                    }
                }
            }

        } else {
            result = mutableListOf()
            result.add(currentNumber)
        }
        return result
    }
}