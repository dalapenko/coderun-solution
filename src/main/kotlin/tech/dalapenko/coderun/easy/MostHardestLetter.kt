package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 180. Самая сложная буква
 *
 * Василий решил улучшить свою скорость печати. Он заметил, что некоторые буквы на клавиатуре он ищет дольше, чем другие. Ему интересно, какую букву он искал дольше всего. Напишите программу, которая поможет Василию узнать это.
 *
 * Василий ввел N букв.
 *
 * Строка S – строка, введенная Василием, имеет длину N.
 *
 * Mассив A содержит N целых неотрицательных чисел, каждое число
 * 𝐴𝑖 – время в миллисекундах от начала ввода до того как была напечатана i-тая буква.
 *
 * Считается, что Василий начал искать следующую букву сразу после того, как напечатал предыдущую. Букву с индексом 0 он искал 𝐴0 миллисекунд.
 *
 * Формат ввода
 * В первой строке входных данных находится N - количество введенных букв.
 *
 * Во второй строке находится S – введенная строка, состоящая из N букв.
 *
 * В третьей строке находится A – N целых неотрицательных чисел через пробел.
 *
 * Ограничения
 * 0 < N < 10
 * 0 ≤ A < 10^8
 *
 * Массив A отсортирован в порядке возрастания: Ai ≤ Aj если i < j
 *
 * Формат вывода
 * Выведите букву, которую Василий искал дольше всего. Если букв с одинаковым временем поиска несколько, выведите ту, что он напечатал последней.
 */
object MostHardestLetter {

    fun solution(word: String, duration: List<Int>): Char? {
        var maxTimeSpent = 0 to duration[0]
        var lastLetterTimer = duration[0]

        duration
            .drop(1)
            .forEachIndexed { index, time ->
                val timeSpent = time - lastLetterTimer
                if (timeSpent >= maxTimeSpent.second) {
                    maxTimeSpent = index + 1 to timeSpent
                }
                lastLetterTimer = time
            }

        return word.getOrNull(maxTimeSpent.first)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val length = reader.readLine().toInt()
    val word = reader.readLine().take(length)
    val duration = reader.readLine().split(" ").map(String::toInt)

    val mostHardestLetter = MostHardestLetter.solution(word, duration)

    writer.write(mostHardestLetter.toString())
    reader.close()
    writer.close()
}