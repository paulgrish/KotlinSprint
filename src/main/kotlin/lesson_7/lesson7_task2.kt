package lesson_7

/**
 * Задача 2 к Уроку 7
 *
 * Создай программу, имитирующую авторизацию по коду из смс. Программа будет “высылать” код из четырех цифр
 * (случайное число от 1000 до 9999).
 *
 * Выведи его в консоль с текстом “Ваш код авторизации: N”. Далее программа запрашивает ввод кода, чтобы авторизоваться.
 * – Если код введён неверно – программа вышлет новый (отобразит в консоли) и снова будет запрашивать его ввод для
 * попытки авторизации.
 * – Если код введен верно – программа отображает приветствие и завершает работу.
 */
fun main() {

    var autorizationCode: Int
    var userAutorizationCode: Int

    while (true) {
        autorizationCode = (AUTHORIZATION_CODE_START .. AUTHORIZATION_CODE_END).random()
        println("Ваш код авторизации: $autorizationCode")

        print("Введите ваш код авторизации: ")
        userAutorizationCode = readln().toInt()

        if (userAutorizationCode == autorizationCode)
            break
    }

    println("Авторизация прошла успешно!")

}

const val AUTHORIZATION_CODE_START = 1000
const val AUTHORIZATION_CODE_END = 9999
