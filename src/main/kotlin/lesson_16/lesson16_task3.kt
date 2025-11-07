package lesson_16

/**
 * Задача 3 к Уроку 16
 *
 * Создай класс, описывающий пользователя, который хранит поля логин и пароль.
 * Пароль не должен быть виден в теле главной функции, но должен быть способ проверить, что пароль введен верно.
 * Функция валидации должна принимать строку и возвращать результат проверки (и только его – без распечатки или
 * генерации других строк).
 *
 * Выведи информацию о корректности введенного пароля.
 */
fun main() {
    val user = User("ABC", "123")
    println("User: ${user.login}")
    print("Enter password: ")
    val pw = readln()
    if (user.checkPassword(pw))
        println("Пароль верен")
    else
        println("Пароль НЕ верен")
}

class User(
    val login: String,
    private val password: String,
) {
    fun checkPassword(testPassword: String) = testPassword == password
}