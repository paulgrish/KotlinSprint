package lesson_17

/**
 * Задача 5* к Уроку 17
 *
 * Класс описывает пользователя и хранит свойства логин и пароль (без инициализации по умолчанию).
 *
 * - при попытке изменить пароль, в консоль должно выводиться «Вы не можете изменить пароль».
 * - при попытке прочитать пароль – вместо символов должны отображаться звездочки (по количеству символов пароля).
 * - при изменении логина в консоли должно печататься сообщение об успешной смене логина.
 *
 * Создай пользователя с произвольными данными и протестируй изменение логина и пароля. Вся реализация должна быть
 * на сеттерах и геттерах.
 */
fun main() {
    val user = UserData("CptPower", "1234")
    println("${user.login} : ${user.password}")
    user.login = "CptPower"
    user.login = "Mickey"
    println("${user.login} : ${user.password}")
    user.password = "abcdefgh"
    println("${user.login} : ${user.password}")
}

class UserData(
    _login: String,
    _password: String,
) {
    var login: String = _login
        set(value) {
            if (value != field) {
                field = value
                println("Логин успешно изменен")
            } else {
                println("Логин не был изменен")
            }
        }

    var password: String = _password
        set(value) = println("Вы не можете изменить пароль")
        get() {
            var result = ""
            field.forEach {
                result += '*'
            }
            return result
        }
}