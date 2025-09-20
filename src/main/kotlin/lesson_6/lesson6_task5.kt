package org.example.lesson_6

import kotlin.ranges.random

/**
 * Задача 4 к Уроку 6
 *
 * Напиши небольшую консольную игру, в которой нужно угадать число в промежутке от 1 до 9. Игроку дается 5 попыток,
 * чтобы угадать это число.
 *  – если игрок угадывает число, выводится сообщение “Это была великолепная игра!” и программа завершает работу;
 *  – если не угадывает, то отображается "Неверно" или что-то на твое усмотрение и оставшееся количество попыток;
 *  – после истечения попыток выводится сообщение “Было загадано число N”.
 */
fun main() {

    val hiddenNumber = (HIDDEN_NUMBER_START..HIDDEN_NUMBER_END).random()
    var attempt = NUMBER_OF_ATTEMPTS

    println("Отгадайте число от $HIDDEN_NUMBER_START до $HIDDEN_NUMBER_END за $NUMBER_OF_ATTEMPTS попыток.")

    while (attempt > 0) {

        var userNumber: Int

        while (true) {
            println("Ведите ваше число:")
            userNumber = readln().toInt()
            if (userNumber >= HIDDEN_NUMBER_START && userNumber <=HIDDEN_NUMBER_END)
                break
            println("Число должно быть от $HIDDEN_NUMBER_START до $HIDDEN_NUMBER_END!")
        }

        if (userNumber == hiddenNumber)
            break

        println("Неверно.\nОсталось попыток: ${--attempt}.")
    }

    if (attempt > 0)
        println("Это была великолепная игра!")
    else
        println("Было загадано число $hiddenNumber.")

}

const val HIDDEN_NUMBER_START = 1
const val HIDDEN_NUMBER_END = 9
const val NUMBER_OF_ATTEMPTS = 5