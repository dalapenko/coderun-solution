package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class RLESeriesCodingTest {

    @Test
    fun example1() {
        val result = RLESeriesCoding.solution("A15BA5")

        assertEquals(
            expected = 21,
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = RLESeriesCoding.solution("ABCDR")

        assertEquals(
            expected = 5,
            actual = result
        )
    }

    @Test
    fun example3() {
        val result = RLESeriesCoding.solution("Z123XY")

        assertEquals(
            expected = 125,
            actual = result
        )
    }
}