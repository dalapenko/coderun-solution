package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 310. Кодирование длин серий
 *
 * Кодирование длин серий (RLE) — алгоритм сжатия данных, заменяющий повторяющиеся символы на один символ и число его повторов.
 * Серией называется последовательность, состоящая из нескольких одинаковых символов (более одного).
 * При кодировании строка одинаковых символов, составляющих серию, заменяется строкой, содержащей сам повторяющийся символ и количество его повторов.
 *
 * Например, строка AAAABBB будет сжата в строку A4B3, а строка AAAAAAAAAAAAAAABAAAAA — в строку A15BA5.
 *
 * Вам дана сжатая строка, найдите длину исходной строки. Длина исходной строки не превосходит 1000 символов, все символы исходной строки — заглавные большие буквы латинского алфавита.
 *
 * Формат ввода
 * В единственной строке входных данных содержится непустая строка
 * 𝑠
 * s. Гарантируется, что
 * 𝑠
 * s результат корректного сжатия некоторой строки.
 *
 * Формат вывода
 * Выведите длину исходной строки.
 */
object RLESeriesCoding {

    fun solution(input: String): Int {
        val letterRegex = "[A-Z]".toRegex()
        val digitRegex = "\\d+".toRegex()

        val inputLetterCount = letterRegex.findAll(input).count()
        val inputDigits = digitRegex.findAll(input)

        val inputDigitsCount = inputDigits.count()
        val inputDigitsSum = inputDigits.mapNotNull { it.value.toIntOrNull() }.sum()

        val countOfSingleLetter = inputLetterCount - inputDigitsCount
        return inputDigitsSum + countOfSingleLetter
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine()

    val originalLength = RLESeriesCoding.solution(input)

    writer.write(originalLength.toString())
    reader.close()
    writer.close()
}