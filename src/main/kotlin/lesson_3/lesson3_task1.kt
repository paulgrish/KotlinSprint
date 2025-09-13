package lesson_3

/**
 * При входе в приложение высвечивается приветствие. Представим, что мы пишем функцию, которая будет выводить
 * приветствие с именем пользователя на экран (в нашем случае в консоль). Tекст приветствия может меняться в
 * зависимости от времени суток. Так, например, выводится приветствие при входе в приложение Сбербанка.
 *
 * Приветствие и имя пользователя должны храниться в отдельных переменных. Вывести в консоль два приветствия
 * (для дня и для вечера), перезаписывая данные в одну исходную переменную.
 */
fun main() {

    val userName = "Ivan"
    val textForAfternoon = "afternoon"
    val textForEvening = "evening"

    var helloMessage = "Good $textForAfternoon, $userName!"

    println(helloMessage)

    helloMessage = "Good $textForEvening, $userName!"

    println(helloMessage)

}