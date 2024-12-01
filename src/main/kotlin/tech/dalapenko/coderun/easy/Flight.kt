package tech.dalapenko.coderun.easy

import java.io.BufferedReader
import java.io.BufferedWriter
import java.io.InputStreamReader
import java.io.OutputStreamWriter
import java.time.LocalTime
import java.time.OffsetTime
import java.time.ZoneOffset
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

/**
 * 284. Перелёт
 *
 * Иван Иванов летит из страны А в страну Б, и хочет скачать фильмы в дорогу. Он знает время прибытия, время отправления и разницу в часовых поясах. Помогите Ивану определить, сколько времени он проведёт в самолёте.
 *
 * Формат ввода
 * На вход подается 3 строки: Время отправления (от 0:00, до 23:59) Время прибытия (от 0:00 до 23:59) Разница в часовых поясах (от -12 до +14)
 *
 * Формат вывода
 * Нужно вывести время в полёте: <количество_часов>:<количество_минут> (минимальное неотрицательное).
 *
 * Примечание
 * Гарантируется, что подаются корректные данные.
 */
object Flight {

    fun solution(departure: String, arrival: String, timeZoneDiff: String): String {
        val timeFormatter = DateTimeFormatter.ofPattern("H:mm")
        val departureTime =  LocalTime.parse(departure, timeFormatter).let { time ->
            if (timeZoneDiff == "0") return@let time

            OffsetTime.of(time, ZoneOffset.UTC).withOffsetSameInstant(ZoneOffset.of(timeZoneDiff)).toLocalTime()
        }

        val arrivalTime = LocalTime.parse(arrival, timeFormatter)

        val diff = departureTime.until(arrivalTime, ChronoUnit.MINUTES).let { time ->
            if (time > 0) return@let time

            DAY_MINUTES_COUNT + time
        }

        val diffHours = diff / 60
        val diffMinutes = (diff % 60)
        val diffLocalTime = LocalTime.of(diffHours.toInt(), diffMinutes.toInt())

        return diffLocalTime.format(timeFormatter)
    }
}

fun main() {
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val writer = BufferedWriter(OutputStreamWriter(System.out))

    val departure = reader.readLine()
    val arrival = reader.readLine()
    val timeZoneDiff = reader.readLine()

    val timeToFlight = Flight.solution(departure, arrival, timeZoneDiff)

    writer.write(timeToFlight)
    reader.close()
    writer.close()
}

private const val DAY_MINUTES_COUNT = 24 * 60