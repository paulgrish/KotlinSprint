package lesson_20

/**
 * Задача 1 к Уроку 20
 *
 * В приложении есть SplashScreen, который приветствует пользователя, обращаясь по имени.
 *
 * Напиши лямбда-функцию с явным указанием типа при ее объявлении, которая будет создавать строку с текстом
 * «С наступающим Новым Годом, username!», где username – это имя пользователя. Выведи строку в консоль.
 */
fun main() {

    val username = "paulgri"

    val splashLambda = { username: String -> String
        "С наступающим Новым Годом, $username!"
    }

    println(splashLambda(username))

}