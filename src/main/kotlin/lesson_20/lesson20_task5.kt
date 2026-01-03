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

}

class Robot {
    var currentMessage: String? = null
    var modifier: ((String) -> String)? = null

    fun say(): String {
//        if (currentMessage == null)
//            currentMessage = getMessage()
        val msg: String = currentMessage ?: getMessage()
        currentMessage = msg

//        return if (modifier == null)
//            currentMessage
//        else
//            modifier(currentMessage)
        return modifier?.invoke(msg) ?: msg
    }

    fun getMessage(): String {
        val messages = listOf(
            "Я готов, мой повелитель!",
            "Система запущена и готова к работе.",
            "Инициализация прошла успешно, готов к выполнению заданий.",
            "Есть ошибки инициализации, необходимо проверить журнал и перезапустить систему.",
            "Привет! Ты кто? Я тебя не узнаю.",
        )
//        currentMessage = messages[(0 until messages.size).random()]
        return messages.shuffled().first()
    }
}