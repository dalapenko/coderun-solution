package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class NearestNumberTest {

    @Test
    fun example1() {
        val result = NearestNumber.solution(
            target = 6,
            array = intArrayOf(1, 2, 3, 4, 5)
        )
        assertEquals(
            expected = 5,
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = NearestNumber.solution(
            target = 3,
            array = intArrayOf(5, 4, 3, 2, 1)
        )
        assertEquals(
            expected = 3,
            actual = result
        )
    }
}