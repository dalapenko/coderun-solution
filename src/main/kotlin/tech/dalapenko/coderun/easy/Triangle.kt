package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 81. Треугольник
 *
 * Даны три натуральных числа. Возможно ли построить треугольник с такими сторонами? Если это возможно, выведите строку YES, иначе выведите строку NO.
 *
 * Треугольник — это три точки, не лежащие на одной прямой.
 *
 * Формат ввода
 * Вводятся три натуральных числа.
 *
 * Формат вывода
 * Выведите ответ на задачу.
 */
object Triangle {

    fun solution(a: Int, b: Int, c: Int): Boolean {
        if (a + b <= c || a + c <= b || b + c <= a) {
            return false
        }

        return true
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val a = reader.readLine().toInt()
    val b = reader.readLine().toInt()
    val c = reader.readLine().toInt()

    val isTriangle = Triangle.solution(a, b, c)

    writer.write(if (isTriangle) "YES" else "NO")
    reader.close()
    writer.close()
}