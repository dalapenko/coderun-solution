package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class IsGrowingListTest {

    @Test
    fun example1() {
        val result = IsGrowingList.solution(
            listOf(1, 7, 9)
        )

        assertTrue(result)
    }

    @Test
    fun example2() {
        val result = IsGrowingList.solution(
            listOf(1, 9, 7)
        )

        assertFalse(result)
    }

    @Test
    fun example3() {
        val result = IsGrowingList.solution(
            listOf(2, 2, 2)
        )

        assertFalse(result)
    }

}