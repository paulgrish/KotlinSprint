package lesson_17

/**
 * Задача 1 к Уроку 17
 *
 * Создай класс, описывающий элемент викторины. В primary конструкторе два текстовых свойства: вопрос и ответ.
 *
 * Явно пропиши для вопроса геттер, для ответа геттер и сеттер.
 */
fun main() {

    val quiz = Quiz("Здесь есть кто-нибудь?", "Его и сейчас здесь нет.")
    quiz.printInfo()
    quiz.answer = "Да, кто-нибудь есть."
    quiz.printInfo()
    quiz.answer = "Нет, кто-нибудя нету."
    quiz.printInfo()
}

class Quiz(
    question_: String,
    answer_: String,
) {

    val question: String = question_
        get() = field

    var answer: String? = answer_
        get() = field
        set(value) {
            field = value
        }

    fun printInfo() {
        println("$question : $answer")
    }
}