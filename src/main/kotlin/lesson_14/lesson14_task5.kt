package lesson_14

/**
 * Задача 5* к Уроку 14
 *
 * Создай класс Chat, который реализует обсуждение в мессенджере, аналогичному Discord. Класс должен иметь
 * следующие методы:
 * - addMessage() — добавляет обычное сообщение в чат, принимает на вход текст и автора сообщения;
 * - addThreadMessage() — добавляет сообщение в тред к предыдущему сообщению (для начала обсуждения), дополнительно
 * принимает на вход parentMessageId для идентификации сообщения, под которым создается ветка обсуждения;
 * Сообщения чата должны храниться в списке, в классе Chat. Для создания сообщений соответствующих типов используй
 * классы Message и ChildMessage в соответствующей иерархии. У каждого типа сообщения должен быть id.
 * - printChat() — печатает все сообщения чата. Если создано дочернее сообщение, необходимо применить для вывода
 * табуляцию и печатать его под родительским сообщением. Используй groupBy() для группировки сообщений по
 * parentMessageId, если сообщение является экземпляром ChildMessage, или по id если это обычное сообщение.
 */
fun main() {

    val chat = Chat()

    chat.addMessage("tom", "Где взять задание на лабу по АиП?")
    val pid1 = chat.getLastThreadHeadMessageId()
    chat.addThreadMessage("jerry", "В курсе на мудле смотри в практикуме",pid1)
    chat.addThreadMessage("spike", "не тупи, у препода вариант сперва попроси, можыш в месаже в мудле", pid1)

    chat.addMessage("paulgri", "кто может помочь с запускам nginx в облаке, из коробки не работает( на cloud.ru")

    chat.addMessage("mironov", "второй год бьюсь, кто курсовой по си поможет? Гришмановский зверь")
    val pid2 = chat.getLastThreadHeadMessageId()
    chat.addThreadMessage("tom", "тут никто не поможет, переводись", pid2)

    chat.addThreadMessage("walt", "выбери вариант попроще, потом скажи что не понял, он примет, у меня прокатило))", pid1)
    chat.addThreadMessage("paulgri", "каждый четверг 6 пара, хоть раз бы пришел, может уже сдал бы", pid2)

    chat.printChat()
}

class Chat() {

    val messages = mutableListOf<BaseMessage>()

    fun addMessage(author: String, text: String) {
        messages.add(Message(author, text))
    }

    fun addThreadMessage(author: String, text: String, parentMessageId: Int) {
        messages.find { it is Message && it.id == parentMessageId }.let {
            if (it == null) {
                println("Error: parent message $parentMessageId not found. New message dropped.")
            } else {
                messages.add(ChildMessage(author, text, parentMessageId))
            }
        }
    }

    fun printChat() {
        messages.groupBy { it.getGroupId() }.forEach { it.value.forEach { it.printMessage() } }
    }

    fun getLastThreadHeadMessageId() = messages.last().id

}

abstract class BaseMessage(
    val author: String,
    val text: String,
) {
    val id: Int = getNextId()

    abstract fun getGroupId(): Int

    open fun printMessage() {
        println("$author: $text")
    }

    companion object {
        private var idCounter: Int = 0
        private fun getNextId() = ++idCounter
        fun getLastId() = idCounter
    }
}

/**
 * Head message. Starts messages thread.
 */
class Message(
    author: String,
    text: String,
) : BaseMessage(author, text) {

    override fun getGroupId(): Int = id

}

class ChildMessage(
    author: String,
    text: String,
    val parentMessageId: Int,
) : BaseMessage(author, text) {

    override fun getGroupId(): Int = parentMessageId

    override fun printMessage() {
        print("\t")
        super.printMessage()
    }

}