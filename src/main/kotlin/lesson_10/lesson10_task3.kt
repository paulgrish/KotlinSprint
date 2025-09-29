package lesson_10

/**
 * Задача 3 к Уроку 10
 *
 * Напиши программу, которая генерирует пароли. Пароль должен состоять из последовательно чередующихся цифр и
 * специальных символов. Например, 4#4%2!.
 * - пользователь сам задает длину пароля;
 * - для генерации пароля должна быть отдельная функция, принимающая целочисленное значение длины пароля и
 * возвращающая готовый пароль;
 * - пароль должен содержать цифры от 0 до 9, специальные символы: !"#$%&'()*+,-./ и пробел (всего 16 спецсимволов).
 */
fun main() {

    var passwordLength: Int

    while (true) {
        print("Задайте длину генерируемого пароля: ")
        passwordLength = readln().toInt()
        if (passwordLength > 0)
            break
        println("Длина пароля должны быть положительным числом!")
    }

    val password = makePassword(passwordLength)
    println("Ваш новый пароль: [$password]")

}

fun makePassword(length: Int): String {

    val setOfDigits = '0'..'9'
    val setOfSpecials = ' '..'/'

    var passwordString = ""
    for (i in 1..length) {
        passwordString += (
                if (i % 2 == 0)
                    setOfSpecials
                else
                    setOfDigits
                ).random()
    }

    return passwordString
}