package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 153. Мягкие подстилки
 *
 * Программист Вова купил полоску земли шириной
 * h и бесконечной длиной. Так как он любит пёсиков, Вова решил выделить место на полоске для вольера, в котором будут жить его питомцы. Вова хочет покрыть участок этой полосы длиной
 * w мягкими подстилками. Но у программиста мало денег, поэтому пришлось использовать марку «PLANKS».
 *
 * Подстилки имеют форму вытянутого прямоугольника 1∗x, причем их надо укладывать так:
 * Подстилки кладутся вдоль купленной Вовой полоски, то есть горизонтально. Начинать укладку ряда нужно с левого края полоски.
 * Начинать новый ряд нельзя, пока длина старого строго меньше w. Так как все подстилки упакованы, доставать их можно только в том порядке, в котором их привезли.
 * Участок длины  w считается покрытым, тогда и только тогда, когда длина каждого из h рядов ≥ w. Вова уже сделал заказ подстилок и хочет понять, какую максимальную длину участка
 * w он сможет ими покрыть.
 *
 * Формат ввода
 * В первой строке даны два целых числа — ширина полоски (1≤h≤100000) и количество подстилок в заказе (h≤n≤1000000). В следующей строке даны
 * n целых чисел — длины подстилок (1≤x≤1000)
 *
 * Формат вывода
 * В единственной строке вывести одно целое число — длину участка w.
 */
object SoftBegging {

    fun solution(targetWidth: Int, beggingList: List<Int>): Long {
        val isCoverable: (Long) -> Boolean = coverable@{ width ->
            var currentRowWidth = 0L
            var rowsCovered = 0

            for (begging in beggingList) {
                if (currentRowWidth + begging >= width) {
                    rowsCovered++
                    currentRowWidth = 0L

                    if (rowsCovered == targetWidth) return@coverable true
                } else {
                    currentRowWidth += begging
                }
            }

            false
        }

        var min: Long = 0
        var max: Long = 1_000_000 * 1_000

        while (min < max) {
            val mid = (max + min + 1) / 2

            if (isCoverable(mid)) {
                min = mid
            } else {
                max = mid - 1
            }
        }

        return min
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val (targetWidth, beggingCount) = reader.readLine()
        .split(" ")
        .let { it[0].toInt() to it[1].toInt() }
    val beggingList = reader.readLine()
        .split(" ")
        .take(beggingCount)
        .map(String::toInt)

    val resultWidth = SoftBegging.solution(targetWidth, beggingList)

    writer.write(resultWidth.toString())

    reader.close()
    writer.close()
}