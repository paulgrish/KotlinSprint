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

    val passwordCapsAlphaSet = 'A'..'Z'
    val passwordStrokeAlphaSet = 'a'..'z'
    val passwordDigitSet = '0'..'9'
    val passwordTotalCharSet =
        passwordCapsAlphaSet.toList() + passwordStrokeAlphaSet.toList() + passwordDigitSet.toList()

    var passwordLength: Int

    while (true) {
        print("Задайте длину пароля (не менее $PASSWORD_MIN_LENGTH символов): ")
        passwordLength = readln().toInt()
        if (passwordLength >= PASSWORD_MIN_LENGTH)
            break
        println("Длина пароля должна быть не менее $PASSWORD_MIN_LENGTH символов!")
    }

    val passwordCharList = mutableListOf<Char>(
        passwordCapsAlphaSet.random(),
        passwordStrokeAlphaSet.random(),
        passwordDigitSet.random(),
    )

    for (i in passwordCharList.size until passwordLength) {
        passwordCharList += passwordTotalCharSet.random()
    }
    var password = passwordCharList.joinToString("") { it.toString() }

    println("Ваш новый пароль: $password")

}

const val PASSWORD_MIN_LENGTH = 6