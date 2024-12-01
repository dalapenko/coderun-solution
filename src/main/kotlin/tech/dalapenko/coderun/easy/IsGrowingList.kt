package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 72. Возрастает ли список?
 *
 * Дан список. Определите, является ли он монотонно возрастающим (то есть верно ли, что каждый элемент этого списка строго больше предыдущего).
 *
 * Выведите YES, если массив монотонно возрастает и NO в противном случае.
 */
object IsGrowingList {

    fun solution(list: List<Int>): Boolean {
        if (list.size < 2) return true

        var lastNum = list.first()

        if (list.size == 2 && lastNum < list.last()) return true

        (1 ..< list.size).forEach { index ->
            val cNum = list[index]
            if (lastNum >= cNum) return false
            lastNum = cNum
        }

        return true
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val inputList = reader.readLine().split(" ").map(String::toInt)

    val isGrowing = IsGrowingList.solution(inputList)

    writer.write(if (isGrowing) "YES" else "NO")
    reader.close()
    writer.close()
}