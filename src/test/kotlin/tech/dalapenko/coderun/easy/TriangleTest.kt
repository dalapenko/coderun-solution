package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertTrue

class TriangleTest {

    @Test
    fun example1() {
        val result = Triangle.solution(3, 4, 5)
        assertTrue(result)
    }

    @Test
    fun example2() {
        val result = Triangle.solution(3, 5, 4)
        assertTrue(result)
    }

    @Test
    fun example3() {
        val result = Triangle.solution(4, 5, 3)
        assertTrue(result)
    }
}