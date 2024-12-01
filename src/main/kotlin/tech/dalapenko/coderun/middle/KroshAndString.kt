package tech.dalapenko.coderun.middle

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 4729. Крош и строка
 *
 * У Кроша есть строка, состоящая из n строчных английских букв.
 * За один ход Крош может выбрать два соседних равных символа в этой строке и удалить их,
 * при этом получится новая строка, над которой Крош и дальше может выполнять ходы.
 * Например, если есть строка abccbb, он может выбрать третий и четвертый символы и получить строку abbb,
 * а затем выбрать, например, второй и третий символы из строки abbb и получить строку ab; а может в начале из строки
 * abccbb выбрать пятый и шестой символы и получить строку abcc. Может ли Крош из данной строки удалить все символы?
 *
 * Формат ввода
 * В первой строке дано число 1≤n≤2∗10^5 - длина строки. В следующей строке записана сама строка, состоящая из
 * n строчных английских букв.
 *
 * Формат вывода
 * Выведите 1, если Крош может получить из данной строки пустую, и 0 иначе.
 */
object KroshAndString {

    fun solution(input: String): Boolean {
        val stack = ArrayDeque<Char>()

        for (char in input) {
            if (stack.lastOrNull() == char) {
                stack.removeLastOrNull()
            } else {
                stack.add(char)
            }
        }

        return stack.isEmpty()
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val length = reader.readLine().toInt()
    val input = reader.readLine().take(length)

    val isEmpty = KroshAndString.solution(input)

    writer.write(if (isEmpty) "1" else "0")
    reader.close()
    writer.close()
}