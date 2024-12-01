package tech.dalapenko.coderun.easy

import kotlin.test.Test
import kotlin.test.assertEquals

class WordsInTextCountingTest {

    @Test
    fun example1() {
        val result = WordsInTextCounting.solution(EXAMPLE_1_TEXT)

        assertEquals(
            expected = 19,
            actual = result
        )
    }
}

private const val EXAMPLE_1_TEXT = """
She sells sea shells on the sea shore;
The shells that she sells are sea shells I'm sure.
So if she sells sea shells on the sea shore,
I'm sure that the shells are sea shore shells.
"""

