package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals


class GameOfMaximTest {

    @Test
    fun example1() {
        val result = GameOfMaxim.solution(
            enemyList = listOf(1, 1, 1)
        )

        assertEquals(
            expected = "Possible" to listOf(1, 2, 3),
            actual = result
        )
    }

    @Test
    fun example2() {
        val result = GameOfMaxim.solution(
            enemyList = listOf(7, 1, 5)
        )

        assertEquals(
            expected = "Impossible" to emptyList(),
            actual = result
        )
    }
}