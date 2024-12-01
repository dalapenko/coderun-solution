package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class OpenCalculatorTest {

    @Test
    fun example1() {
        val result = OpenCalculator.solution(
            targetNumber = 1123,
            availableNumbers = listOf(1, 2, 3)
        )

        assertEquals(expected = 0, actual = result)
    }

    @Test
    fun example2() {
        val result = OpenCalculator.solution(
            targetNumber = 1001,
            availableNumbers = listOf(1, 2, 3)
        )

        assertEquals(expected = 1, actual = result)
    }

    @Test
    fun example3() {
        val result = OpenCalculator.solution(
            targetNumber = 123,
            availableNumbers = listOf(5, 7, 3)
        )

        assertEquals(expected = 2, actual = result)
    }
}