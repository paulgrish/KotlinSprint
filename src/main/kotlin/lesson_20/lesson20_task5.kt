package lesson_20

/**
 * Задача 5* к Уроку 20
 *
 * Программируем робота. Робот умеет говорить и работать с модификаторами речи. Речь реализуется методом say().
 * Модификатор устанавливается функцией setModifier(), принимающей лямбду.
 * Робот произносит одну из случайных 5 фраз (придумай фразы самостоятельно). Реализуй модификатор, инвертирующий
 * слова робота.
 * В результате в главной функции должен быть воспроизведен такой алгоритм:
 * – Вызов say(). Метод печатает одну фразу в обычном виде.
 * – Вызов setModifier(). Устанавливает переданный в него модификатор строки.
 * – Вызов say(). Метод выводит одну фразу в инвертированном виде.
 */
fun main() {
    val robot = Robot()
    robot.say()
    robot.setModifier {
        it.reversed()
    }
    robot.say()
}

class Robot {
    var currentMessage: String? = null
    private var modifier: ((String) -> String)? = null

    fun say() {
        val msg: String = currentMessage ?: getMessage()
        currentMessage = msg
        println(modifier?.invoke(msg) ?: msg)
    }

    fun setModifier(mdf: ((String) -> String)?) {
        modifier = mdf
    }

    fun getMessage(): String {
        return listOf(
            "Я готов, мой повелитель!",
            "Система запущена и готова к работе.",
            "Инициализация прошла успешно, готов к выполнению заданий.",
            "Есть ошибки инициализации, необходимо проверить журнал и перезапустить систему.",
            "Привет! Ты кто? Я тебя не узнаю.",
        ).shuffled().first()
    }
}