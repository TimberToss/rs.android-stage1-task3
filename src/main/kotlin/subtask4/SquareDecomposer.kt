package subtask4


class SquareDecomposer {

    fun decomposeNumber(number: Int): Array<Int>? {
        val result: MutableList<Long>? = recursiveDecompose(number.toLong(), number * number.toLong())
        result?.removeAt(result.size - 1)
        return result?.map { it.toInt() }?.toTypedArray()
    }

    private fun recursiveDecompose(currentNumber: Long, remainder: Long): MutableList<Long>? {
        if (remainder == 0L) {
            val result = mutableListOf<Long>()
            result.add(currentNumber)
            return result
        }

        for (i in currentNumber - 1 downTo 1) {
            if (remainder - i * i >= 0) {
                val result = recursiveDecompose(i, remainder - i * i)
                if (result != null) {
                    result.add(currentNumber)
                    return result
                }
            }
        }
        return null
    }
}