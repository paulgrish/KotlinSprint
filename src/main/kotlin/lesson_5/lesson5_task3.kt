package lesson_5

/**
 * Задача 3 к Уроку 5
 *
 * Для алгоритма простого приложения-лотереи, нужно угадать два числа от 0 до 42. Если угадать только одно – игрок
 * получает утешительный приз. Напиши программу, проверяющую выигрыш. Пользователь должен вводить числа в консоль.
 * Правильные числа заранее известны и хранятся в переменных. Оформить ввод текстовыми подсказками о том, что нужно
 * вводить. Вывести отдельным сообщением, какие числа были нужны для победы.
 *
 * - если оба числа угаданы вывести “Поздравляем! Вы выиграли главный приз!”;
 * - если угадано только одно число, вывести “Вы выиграли утешительный приз!”;
 * - если не угадано ничего, вывести “Неудача!”;
 * - программа должна учитывать ввод чисел в обратном порядке.
 */
fun main() {

    val number1 = (MIN_NUMBER..MAX_NUMBER).random()
    val number2 = (MIN_NUMBER..MAX_NUMBER - 1).random().let {
        if (it >= number1) it + 1 else it
    }

    println("Введите два числа от $MIN_NUMBER до $MAX_NUMBER включительно через пробел:")
    val (userNumber1, userNumber2) = readln().split(' ').mapNotNull { it.toIntOrNull() }.take(2)

    val resultMessage =
        if (userNumber1 == number1 && userNumber2 == number2 || userNumber1 == number2 && userNumber2 == number1) {
            "Поздравляем! Вы выиграли главный приз!"
        } else if (userNumber1 == number1 || userNumber1 == number2 || userNumber2 == number1 || userNumber2 == number2) {
            "Вы выиграли утешительный приз!"
        } else {
            "Неудача!"
        }

    println(resultMessage)
    println("Выигрышные числа: $number1 и $number2")
}

const val MIN_NUMBER = 0
const val MAX_NUMBER = 42