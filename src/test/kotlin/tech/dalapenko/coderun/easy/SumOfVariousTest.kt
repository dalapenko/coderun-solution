package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class SumOfVariousTest {

    @Test
    fun example1() {
        val result = SumOfVarious.solution(
            numList = listOf(3, 5, 4)
        )
        assertEquals(
            expected = 12L,
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = SumOfVarious.solution(
            numList = listOf(5, 5, 5, 5, 5)
        )
        assertEquals(
            expected = 5L,
            actual = result
        )
    }

    @Test
    fun example3() {
        val result = SumOfVarious.solution(
            numList = listOf(7, 10, 3, 2, 7, 4, 8, 5, 9, 10)
        )
        assertEquals(
            expected = 48L,
            actual = result
        )
    }
}