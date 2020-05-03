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
        assertEquals(
            6,
            sum
        ) // 1 * 2 * 3, if number of items in array is less than expected, calculate all the values from array
    }

    @Test
    fun test8() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, -8, -7, -6, -6, 1))
        assertEquals(18144, sum) // 6 * 6 > 8 * 1 hence we don't pick 8
    }

    @Test
    fun test9() {
        val sum = calculator.maxProductOf(2, arrayOf(6, -5, -3, 2))
        assertEquals(15, sum)
    }

    @Test
    fun test10() {
        val sum = calculator.maxProductOf(3, arrayOf(6, -5, -3, 2))
        assertEquals(90, sum)
    }

    @Test
    fun test11() {
        val sum = calculator.maxProductOf(3, arrayOf(-6, -5, -3, 2))
        assertEquals(60, sum)
    }

    @Test
    fun test12() {
        val sum = calculator.maxProductOf(1, arrayOf(-6, -5, -3, 2))
        assertEquals(2, sum)
    }

    @Test
    fun test13() {
        val sum = calculator.maxProductOf(3, arrayOf(-6, -5, -3, -2))
        assertEquals(-30, sum) // -30 > -90
    }

    @Test
    fun test14() {
        val sum = calculator.maxProductOf(5, arrayOf(16, 15, -5, -5, -5, -2))
        assertEquals(4000, sum)
    }

    @Test
    fun test15() {
        val sum = calculator.maxProductOf(4, arrayOf(16, 15, -5, -5, -5, -2))
        assertEquals(6000, sum)
    }

    @Test
    fun test16() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, 8, 7, -6, -5, -2))
        assertEquals(17280, sum)
    }

    @Test
    fun test17() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, 8, -7, -6, -5, -2))
        assertEquals(24192, sum)
    }

    @Test
    fun test18() {
        val sum = calculator.maxProductOf(4, arrayOf(9, 8, 8, -7, -6, -5, -2))
        assertEquals(3024, sum)
    }

    @Test
    fun test19() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, 8, -7, -6, 3, -2))
        assertEquals(24192, sum)
    }

    @Test
    fun test20() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, -7, -6, 3, -2))
        assertEquals(9072, sum)
    }

    @Test
    fun test21() {
        val sum = calculator.maxProductOf(5, arrayOf(9, 8, -7, -6, 3, 2))
        assertEquals(9072, sum)
    }

    @Test
    fun test22() {
        val sum = calculator.maxProductOf(6, arrayOf(1, 1, 1, 0, -1, -1, -1))
        assertEquals(0, sum) // number of negatives is odd and we need all non-zeros elements
    }
}
