package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 304. Проверка палиндрома
 *
 * Палиндром, перевертень — число, буквосочетание, слово или текст, одинаково читающееся в обоих направлениях.
 * Например, число 404; слова «топот» в русском языке и фин. «saippuakivikauppias» (продавец мыла; торговец щёлоком) — самое длинное слово-палиндром в мире; текст «а роза упала на лапу Азора» и пр. (Wikipedia)
 *
 * Вам дана строка s, состоящая только из букв английского алфавита и пробелов. Напишите программу, которая определит, является ли строка s палиндромом.
 *
 * Обратите внимание, что в использованном определении палиндрома пробелы игнорируются, а строчные и заглавные буквы не различаются.
 *
 * Формат ввода
 * В единственной строке записана одна строка s(1≤∣s∣≤500000). Строка не начинается и не заканчивается пробельными символами.
 *
 * Формат вывода
 * В единственной строке выведите It is a palindrome, если s является палиндромом, иначе выведите It is not a palindrome. Программа проверки учитывает регистр.
 */
object PalindromeCheck {

    fun solution(input: String): Boolean {
        var leftIndex = 0
        var rightIndex = input.lastIndex

        while (leftIndex <= rightIndex) {
            val letterOnLeft = input[leftIndex]
            if (letterOnLeft == SPACE_CHAR) {
                leftIndex++
                continue
            }

            val letterOnRight = input[rightIndex]
            if (letterOnRight == SPACE_CHAR) {
                rightIndex--
                continue
            }

            leftIndex++
            rightIndex--

            if (!letterOnLeft.equals(letterOnRight, ignoreCase = true)) return false
        }

        return true
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val input = reader.readLine()

    val isPalindrome = PalindromeCheck.solution(input)

    writer.write(if (isPalindrome) IS_PALINDROME else IS_NOT_PALINDROME)
    reader.close()
    writer.close()
}

private const val SPACE_CHAR = ' '
private const val IS_PALINDROME = "It is a palindrome"
private const val IS_NOT_PALINDROME = "It is not a palindrome"