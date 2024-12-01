package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import kotlin.math.abs

/**
 * 70. Ближайшее число
 *
 * Напишите программу, которая находит в массиве элемент, самый близкий по величине к данному числу.
 *
 * Формат ввода
 * В первой строке задается одно натуральное число N, не превосходящее 1000 — размер массива. Во второй строке содержатся
 * N чисел — элементы массива, целые числа, не превосходящие по модулю 1000. В третьей строке вводится одно целое число
 * x, не превосходящее по модулю 1000.
 *
 * Формат вывода
 * Вывести значение элемента массива, ближайшее к x. Если таких чисел несколько, выведите любое из них.
 */
object NearestNumber {

    fun solution(target: Int, array: IntArray): Int {
        check(array.isNotEmpty())

        var nearestToTarget = array.first()
        if (array.size < 2) return nearestToTarget

        var minDiff = abs(target - nearestToTarget)

        (1 ..< array.size).forEach { index ->
            val arrayNum = array[index]
            val diff = abs(target - arrayNum)

            if (diff > minDiff) return@forEach

            minDiff = diff
            nearestToTarget = arrayNum
        }

        return nearestToTarget
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val arraySize = reader.readLine().toInt()

    val arrayNumbers = reader.readLine()
        .split(" ")
        .map(String::toInt)
        .take(arraySize)
        .toIntArray()

    val targetNumber = reader.readLine().toInt()

    val nearestNumber = NearestNumber.solution(targetNumber, arrayNumbers)

    writer.write(nearestNumber.toString())
    reader.close()
    writer.close()
}