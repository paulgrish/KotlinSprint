package lesson_7

/**
 * Задача 1 к Уроку 7
 *
 * Создай программу, которая генерирует шестизначные пароли. Пусть пароль будет состоять из чередующихся цифр и
 * строчных букв латинского алфавита (без специальных символов). Например, k5p6m2. Выведи сгенерированный пароль
 * в консоль.
 */
fun main() {

    val passwordAlphaSet = 'a'..'z'
    val passwordDigitSet = '0'..'9'

    print("New password: ")
    for (i in 0 until PASSWORD_LENGTH) {
        print(
            (
                if (i % 2 == 0)
                    passwordAlphaSet
                else
                    passwordDigitSet
            ).random()
        )
    }
    println()

}

const val PASSWORD_LENGTH = 6
