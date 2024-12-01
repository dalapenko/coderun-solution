package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeCheckTest {

    @Test
    fun example1() {
        val result = PalindromeCheck.solution("JmrrmJ")

        assertTrue(result)
    }

    @Test
    fun example2() {
        val result = PalindromeCheck.solution("f AoAO  AF")

        assertTrue(result)
    }

    @Test
    fun example3() {
        val result = PalindromeCheck.solution("qOH hra")

        assertFalse(result)
    }
}