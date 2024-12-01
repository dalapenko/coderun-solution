package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class FlightTest {

    @Test
    fun example1() {
        val result = Flight.solution(
            departure = "12:00",
            arrival = "13:05",
            timeZoneDiff = "0"
        )

        assertEquals(
            expected = "1:05",
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = Flight.solution(
            departure = "12:00",
            arrival = "13:00",
            timeZoneDiff = "0"
        )

        assertEquals(
            expected = "1:00",
            actual = result
        )
    }

    @Test
    fun example3() {
        val result = Flight.solution(
            departure = "0:00",
            arrival = "6:25",
            timeZoneDiff = "0"
        )

        assertEquals(
            expected = "6:25",
            actual = result
        )
    }

    @Test
    fun example4() {
        val result = Flight.solution(
            departure = "1:00",
            arrival = "12:50",
            timeZoneDiff = "+1"
        )

        assertEquals(
            expected = "10:50",
            actual = result
        )
    }

    @Test
    fun example5() {
        val result = Flight.solution(
            departure = "1:00",
            arrival = "12:50",
            timeZoneDiff = "-10"
        )

        assertEquals(
            expected = "21:50",
            actual = result
        )
    }
}