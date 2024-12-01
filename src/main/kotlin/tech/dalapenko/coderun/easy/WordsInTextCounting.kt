package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * Во входном файле записан текст (вы можете читать данные из sys.stdin, подключив библиотеку sys). Словом считается последовательность непробельных символов идущих подряд, слова разделены одним или большим числом пробелов или символами конца строки. Определите, сколько различных слов содержится в этом тексте.
 *
 * Формат ввода
 * Вводится текст.
 *
 * Формат вывода
 * Выведите ответ на задачу.
 */
object WordsInTextCounting {

    fun solution(text: String): Int {
        return text
            .split(" ", "\n")
            .filterNot(String::isBlank)
            .toSet()
            .size
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val text = reader.readText()

    val wordsInText = WordsInTextCounting.solution(text)
    writer.write(wordsInText.toString())

    reader.close()
    writer.close()
}