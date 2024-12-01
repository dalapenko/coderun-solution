package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class EasySuggestTest {

    @Test
    fun example1() {
        val result = EasySuggest.solution(
            listOf("sayHello", "println", "sleep", "spendMoney", "log")
        )

        assertEquals(
            expected = 's',
            actual = result
        )
    }
}