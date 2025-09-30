package lesson_10

/**
 * Задача 5* к Уроку 10
 *
 * Реализуй механизм авторизации в интернет-магазине и получения сохраненного ранее списка товаров.
 * Метод авторизации принимает логин и пароль, верифицирует пользователя. Креды (credentials) для входа сохрани в
 * константы.
 * При успешной авторизации – метод генерирует и возвращает токен доступа. Токен - текстовая строка, генерируемая
 * методом авторизации (32 символа, которые включают цифры и буквы англ. алфавита – специальные библиотеки
 * использовать не нужно). Подробнее https://ru.wikipedia.org/wiki/JSON_Web_Token
 * При неудачной авторизации метод возвращает null.
 * Метод получения корзины должен принимать токен и возвращать список товаров (содержимое переменной корзины,
 * произвольный тип данных).
 * Распечатай содержимое корзины или, если вернется null, оповести пользователя о неудачной авторизации. Переменные
 * логин и пароль для корректной авторизации проинициализированы заранее и неизменяемы.
 */
fun main() {

    println("Введите данные для авторизации в нашем интернет-магазине.")
    print("Логин: ")
    val userLogin = readln()
    print("Пароль: ")
    val userPassword = readln()

    val autorizationResult = autorizeUser(userLogin, userPassword)

    if (autorizationResult == null) {
        println("Попытка авторизации неудачна.")
    }
    else {
        val basket = getBasketByToken(autorizationResult)
        println("Содержимое вашей корзины:")
        basket.forEachIndexed { i, it ->
            println("$i: ${it.first} x ${it.second}")
        }
    }

}

const val REGISTERED_USER_LOGIN = "paulgri"
const val REGISTERED_USER_PASSWORD = "abc123"
const val TOKEN_LENGTH = 32

const val MIN_BASKET_SIZE = 3
const val MAX_BASKET_SIZE = 12
const val MIN_POSITION_COUNT = 1
const val MAX_POSITION_COUNT = 6

fun autorizeUser(userLogin: String, userPassword: String): String? {

    return if (userLogin == REGISTERED_USER_LOGIN && userPassword == REGISTERED_USER_PASSWORD)
        makeTokenFor(userLogin, userPassword)
    else
        null

}

fun makeTokenFor(userLogin: String, userPassword: String): String {

    // TODO: generate real unique jwt for each user

    val tokenCharSet = ('a'..'z').toList() + ('A'..'Z').toList() + ('0'..'9').toList()
    var token = ""

    (1..TOKEN_LENGTH).forEach { token += tokenCharSet.random() }

    return token

}

fun getBasketByToken(token: String): List<Pair<String, Int>> {

    // TODO: get real basket by token from DB

    val positionNames = listOf("milk", "bread", "beer", "cheeze", "coffee", "sugar", "salt", "chips", "yogurt",
        "flakes", "eggs", "ketchup", "orange", "apple", "cup", "plate", "spoon", "notebook", "pen")

    return positionNames.shuffled().take((MIN_BASKET_SIZE..MAX_BASKET_SIZE).random()).
        sorted().map { it to (MIN_POSITION_COUNT..MAX_POSITION_COUNT).random() }

}