package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 58. OpenCalculator
 *
 * В новой программе OpenCalculator появилась новая возможность – можно настроить, какие кнопки отображаются, а какие – нет. Если кнопка не отображается на экране, то ввести соответствующую цифру с клавиатуры или копированием из другой программы нельзя. Петя настроил калькулятор так, что он отображает только кнопки с цифрами x, y, z. Напишите программу, определяющую, сможет ли Петя ввести число N, а если нет, то какое минимальное количество кнопок надо дополнительно отобразить на экране для его ввода.
 *
 * Формат ввода
 * Сначала вводятся три различных числа из диапазона от 0 до 9: x, y и z (числа разделяются пробелами). Далее вводится целое неотрицательное число N, которое Петя хочет ввести в калькулятор. Число N не превышает 10000.
 *
 * Формат вывода
 * Выведите, какое минимальное количество кнопок должно быть добавлено для того, чтобы можно было ввести число N (если число может быть введено с помощью уже имеющихся кнопок, выведите 0)
 *
 * Примечание
 * Комментарии к примерам тестов.
 *
 * Число может быть введено имеющимися кнопками.
 *
 * Нужно добавить кнопку 0.
 *
 * Нужно добавить кнопки 1 и 2.
 */
object OpenCalculator {

    fun solution(targetNumber: Int, availableNumbers: List<Int>): Int {
        val requiresNumbers = mutableSetOf<Int>()
        var innerNumber = targetNumber

        while (innerNumber != 0) {
            val currentDigit = innerNumber % 10

            if (!availableNumbers.contains(currentDigit)) {
                requiresNumbers.add(currentDigit)
            }

            innerNumber /= 10
        }

        return requiresNumbers.size
    }

}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val availableNumbers = reader.readLine().split(" ").take(3).map(String::toInt)
    val targetNumber = reader.readLine().toInt()

    val requiredNumbersCount = OpenCalculator.solution(targetNumber, availableNumbers)
    writer.write(requiredNumbersCount.toString())

    reader.close()
    writer.close()
}