package tech.dalapenko.coderun.middle

import kotlin.test.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class KroshAndStringTest {

    @Test
    fun example1() {
        val result = KroshAndString.solution("abccba")

        assertTrue(result)
    }

    @Test
    fun example2() {
        val result = KroshAndString.solution("aba")

        assertFalse(result)
    }

    @Test
    fun example3() {
        val result = KroshAndString.solution("abbb")

        assertFalse(result)
    }

    @Test
    fun example4() {
        val result = KroshAndString.solution("aaabbacc")

        assertTrue(result)
    }

    @Test
    fun example5() {
        val result = KroshAndString.solution("abcaacba")

        assertTrue(result)
    }
}