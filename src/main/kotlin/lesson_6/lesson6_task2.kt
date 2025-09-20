package org.example.lesson_6

/**
 * Задача 2 к Уроку 6
 *
 * Создай простой таймер, который запрашивает у пользователя количество секунд, которые нужно засечь. По истечении
 * заданного времени, выведется сообщение в консоли: “Прошло N секунд”. Где N – количество секунд, введенных
 * пользователем. Программа должна вставать на паузу.
 */
fun main() {

    var timerPeriodInSeconds: Long

    while (true) {
        println("Задайте длительность работы таймера (в секундах):")
        timerPeriodInSeconds = readln().toLong()
        if (timerPeriodInSeconds > 0)
            break
        println("Длительность работы таймера должна быть положительным числом!")
    }

    println("Таймер запущен...")
    Thread.sleep(timerPeriodInSeconds * 1000L)

    println("Прошло $timerPeriodInSeconds секунд")

}