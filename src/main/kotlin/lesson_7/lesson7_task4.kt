package org.example.lesson_6

/**
 * Задача 3 к Уроку 6
 *
 * Нужно усовершенствовать таймер из задачи 6-2 так, чтобы он показывал пользователю сколько секунд осталось в
 * процессе отсчета.
 *  – каждую секунду выводить сообщение такого формата: “Осталось секунд: N”;
 *  – по истечении таймера выводить сообщение “Время вышло”;
 *  – таймер должен быть написан, используя цикл while.
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
    while (timerPeriodInSeconds > 0) {
        println("Осталось секунд: ${timerPeriodInSeconds--}")
        Thread.sleep(1000L)
    }

    println("Время вышло")

}