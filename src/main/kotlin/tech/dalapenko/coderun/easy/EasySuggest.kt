package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 272. Простая подсказка
 *
 * Вика разрабатывает умную IDE и хочет перед вводом кода видеть первую букву самых часто используемых команд.
 *
 * Вика уже написала код, который хранит и обновляет список используемых команд. Помогите ей реализовать функцию поиска буквы, с которой чаще всего начинаются команды.
 *
 * Формат ввода
 * Первая строка входных данных содержит целое число 1≤n≤100) - количество команд. Далее следует si(1≤∣si100), состоящую только из строчных и заглавных латинских букв,
 * где |si| - длина строки |si|.
 *
 * Формат вывода
 * Выведите единственную букву - букву, с которой чаще всего начинаются команды.
 *
 * Если вариантов ответа несколько, выведите любой из них.
 */
object EasySuggest {

    fun solution(commandList: List<String>): Char {
        val usageMap = mutableMapOf<Char, Int>()
        for (command in commandList) {
            command.getOrNull(0)?.let { char ->
                usageMap[char] = usageMap.getOrDefault(char, 0).inc()
            }
        }

        return usageMap.maxBy(Map.Entry<Char, Int>::value).key
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val commandCount = reader.readLine().toInt()
    val inputList = (0 until commandCount).map { reader.readLine() }

    val mostUsageChar = EasySuggest.solution(inputList)

    writer.write(mostUsageChar.toString())
    reader.close()
    writer.close()
}