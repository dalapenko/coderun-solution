package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class MostHardestLetterTest {

    @Test
    fun example1() {
        val result = MostHardestLetter.solution(
            word = "abc",
            duration = listOf(10, 11, 12)
        )

        assertEquals(
            expected = 'a',
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = MostHardestLetter.solution(
            word = "adc",
            duration = listOf(1, 5, 7)
        )

        assertEquals(
            expected = 'd',
            actual = result
        )
    }

    @Test
    fun example3() {
        val result = MostHardestLetter.solution(
            word = "bcda",
            duration = listOf(1, 2, 4, 6)
        )

        assertEquals(
            expected = 'a',
            actual = result
        )
    }

    @Test
    fun example4() {
        val result = MostHardestLetter.solution(
            word = "aabbc",
            duration = listOf(1, 3, 5, 7, 8)
        )

        assertEquals(
            expected = 'b',
            actual = result
        )
    }
}