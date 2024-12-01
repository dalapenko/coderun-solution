package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals


class SoftBeggingTest {

    @Test
    fun example1() {
        val result = SoftBegging.solution(
            targetWidth = 1,
            beggingList = listOf(3, 4)
        )
        assertEquals(
            expected = 7,
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = SoftBegging.solution(
            targetWidth = 2,
            beggingList = listOf(4, 5, 8)
        )
        assertEquals(
            expected = 8,
            actual = result
        )
    }

    @Test
    fun example3() {
        val result = SoftBegging.solution(
            targetWidth = 2,
            beggingList = listOf(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 9)
        )
        assertEquals(
            expected = 9,
            actual = result
        )
    }
}