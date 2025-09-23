package lesson_7

/**
 * Задача 5* к Уроку 7
 *
 * Создай программу, которая генерирует более сложные пароли.
 * – пароль должен содержать цифры, строчные и заглавные буквы - должны присутствовать все три вида символов;
 * – цифры и буквы должны располагаться в случайном порядке;
 * – длина пароля должна задаваться пользователем;
 * – минимальная длина пароля 6 символов.
 */
fun main() {

    val passwordCharSet = ('a' .. 'z').toList() + ('0' .. '9').toList()

    var passwordLength: Int
    var password: String

    while (true) {
        println("Задайте длительность работы таймера (в секундах):")
        passwordLength = readln().toInt()
        if (passwordLength >= 6)
            break
        println("Длительность работы таймера должна быть положительным числом!")
    }

    for (tick in timerPeriodInSeconds downTo 1) {
        println("Осталось секунд: $tick")
        Thread.sleep(1000)
    }

}