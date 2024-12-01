package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter

/**
 * 468. Игра Максима
 *
 * Программист Максим написал игру, в которой игрок на пути к пещере с кладом встречает n других охотников за сокровищами и должен с каждым сыграть в «Камень, ножницы, бумага». При этом путь к пещере, от которого зависит порядок выбора соперника, определяется игроком. Игрок и каждый из соперников имеют определённый уровень. Изначально игрок имеет первый уровень. Если уровень игрока больше уровня соперника или равен ему, игрок побеждает соперника и повышает свой уровень на один. В противном случае игрок погибает. При этом если текущий уровень игрока больше уровня соперника менее чем в два раза, то в этом соревновании игрок получает одно штрафное очко. Если игрок получит три штрафных очка, то он теряет уровень, при этом счётчик штрафных очков сбрасывается. Чтобы не расстраивать своих игроков, Максим хочет предварительно понять, существует ли способ пройти игру, и, если есть хотя бы один способ, узнать его. Для этого Максим сгенерировал карту игры со всеми соперниками, которые встречаются игроку в гонке за сокровищами.
 *
 * Формат ввода
 * В первой строке содержится единственное число n≤10^5 — количество соперников. Во второй строке находится ровно
 * n чисел, уровень очередного соперника 0 ≤ai ≤ 10^6
 *
 * Формат вывода
 * Выведите Impossible, если игру невозможно пройти. В противном случае выведите в первой строке Possible и в следующей строке ровно
 * n чисел от 1 до n — порядок в котором игрок должен встречаться с соперниками. Последовательностей прохождения может быть несколько — в задаче требуется вывести любую приводящую к победе.
 */

object GameOfMaxim {

    fun solution(enemyList: List<Int>): Pair<String, List<Int>> {
        var currentLevel = 1
        var penaltyPoints = 0

        return enemyList
            .mapIndexed { index, enemyLevel ->
                enemyLevel to index + 1
            }
            .sortedBy { (enemyLevel, _) ->
                enemyLevel
            }
            .map { (enemyLevel, enemyIndex) ->
                if (enemyLevel > currentLevel) {
                    return IMPOSSIBLE to emptyList()
                }

                currentLevel++

                if (enemyLevel * 2 > currentLevel) {
                    penaltyPoints++
                }

                if (penaltyPoints == 2) {
                    currentLevel--
                    penaltyPoints = 0
                }

                if (currentLevel < 1) {
                    return IMPOSSIBLE to emptyList()
                }

                return@map enemyIndex
            }.let { enemyOrder ->
                POSSIBLE to enemyOrder
            }
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val enemyCount = reader.readLine().toInt()
    val enemyLevels = reader.readLine()
        .split(" ")
        .take(enemyCount)
        .map(String::toInt)

    val gameResult = GameOfMaxim.solution(enemyLevels)

    writer.write(
        gameResult.let { (result, order) ->
            "$result\n${order.joinToString(" ")}"
        }
    )
    reader.close()
    writer.close()
}

private const val IMPOSSIBLE = "Impossible"
private const val POSSIBLE = "Possible"