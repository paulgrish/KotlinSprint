package lesson_7

import kotlin.math.max

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

    val passwordCapsAlphaSet = 'A'..'Z'
    val passwordStrokeAlphaSet = 'a'..'z'
    val passwordDigitSet = '0'..'9'

    val passwordCharSetList = listOf(
        passwordCapsAlphaSet,
        passwordStrokeAlphaSet,
        passwordDigitSet,
    )

    val passwordTotalCharSet = mutableListOf<Char>()
    passwordCharSetList.forEach {
        passwordTotalCharSet += it.toList()
    }

    val minPasswordLength = max(passwordCharSetList.size, PASSWORD_MIN_LENGTH)
    var passwordLength: Int

    while (true) {
        print("Задайте длину пароля (не менее $minPasswordLength символов): ")
        passwordLength = readln().toInt()
        if (passwordLength >= minPasswordLength)
            break
        println("Длина пароля должна быть не менее $minPasswordLength символов!")
    }

    val passwordCharList = mutableListOf<Char>(
        passwordCapsAlphaSet.random(),
        passwordStrokeAlphaSet.random(),
        passwordDigitSet.random(),
    )

    for (i in passwordCharList.size until passwordLength) {
        passwordCharList += passwordTotalCharSet.random()
    }
    val password = passwordCharList.shuffled().joinToString("") { it.toString() }

    println("Ваш новый пароль: $password")

}

const val PASSWORD_MIN_LENGTH = 6