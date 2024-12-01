package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 294. Сумма различных
 *
 * Отправить на проверку нужно исходный код программы, решающей поставленную задачу.
 *
 * Дан массив a из n целых чисел. Напишите программу, которая выведет сумму различных чисел в массиве.
 *
 * Формат ввода
 * В первой строке входных данных записано число n (1≤n≤100000).
 * Во второй строке записаны n целых чисел ai(0 ≤ 𝑎𝑖 ≤ 1 000 000 000).
 *
 * Формат вывода
 * Выведите единственное число s, сумму различных чисел в массиве a.
 * Будьте внимательны в выборе используемого целочисленного типа данных.
 */
object SumOfVarious {

    fun solution(numList: List<Int>): Long {
        return numList.toSet().sumOf(Int::toLong)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val countOfNum = reader.readLine().toInt()
    val numList = reader.readLine()
        .split(" ")
        .take(countOfNum)
        .map(String::toInt)

    val sumOfVarious = SumOfVarious.solution(numList)

    writer.write(sumOfVarious.toString())
    reader.close()
    writer.close()
}