package lesson_10

/**
 * Задача 2 к Уроку 10
 *
 * Для регистрации в приложении пользователь придумывает логин и пароль. И логин, и пароль должны содержать в себе
 * хотя бы 4 символа. Если всё верно, программа выводит приветственное сообщение.
 * - считывай логин и пароль с консоли поочередно;
 * - вынеси в отдельную функцию валидацию длины введенных данных;
 * - если логин или пароль меньше 4 символов – вывести сообщение: "Логин или пароль недостаточно длинные".
 */
fun main() {

    println("Для регистрации в приложении введите логин и пароль длиной не менее $MIN_LOGIN_PASSWORD_LENGTH символов каждый.")
    print("Логин: ")
    val userlogin = readln()
    print("Пароль: ")
    val userPassword = readln()

    if (!checkLoginPasswordLength(userlogin, userPassword)) {
        println("Логин или пароль недостаточно длинные.")
    }

}

const val MIN_LOGIN_PASSWORD_LENGTH = 4

fun checkLoginPasswordLength(login: String, password: String) =
    login.length >= MIN_LOGIN_PASSWORD_LENGTH && password.length >= MIN_LOGIN_PASSWORD_LENGTH