import org.junit.Assert.assertEquals
import org.junit.Test
import subtask3.ArrayCalculator

class ArrayProductCalculatorTests {

    private val calculator = ArrayCalculator()

    @Test
    fun test1() {
        val sum = calculator.maxProductOf(3, arrayOf(1, 2, 3))
        assertEquals(6, sum) // 1 * 2 * 3
    }

    @Test
    fun test2() {
        val sum = calculator.maxProductOf(4, arrayOf(-100, -2, 50, -7, 1, 3, 10))
        assertEquals(350000, sum) // -100 * -7 * 50 * 10
    }

    @Test
    fun test3() {
        val sum = calculator.maxProductOf(3, arrayOf(-1000000, 20, 5, 1, 7, 5))
        assertEquals(700, sum) // 20 * 5 * 7
    }

    @Test
    fun test4() {
        val sum = calculator.maxProductOf(3, arrayOf(-100, 50, 30, 20, 40, -1))
        assertEquals(60000, sum) // 50 * 30 * 40
    }

    @Test
    fun test5() {
        val sum = calculator.maxProductOf(3, arrayOf("1", "2", "3"))
        assertEquals(0, sum) // strings are not included, 0 by default
    }

    @Test
    fun test6() {
        val sum = calculator.maxProductOf(3, arrayOf(-1, "2", "3", 4))
        assertEquals(-4, sum) // strings are not included
    }

    @Test
    fun test7() {
        val sum = calculator.maxProductOf(4, arrayOf(1, 2, 3))
        assertEquals(6, sum) // 1 * 2 * 3, if number of items in array is less than expected, calculate all the values from array
    }
}