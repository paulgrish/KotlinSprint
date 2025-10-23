package lesson_15

/**
 * Задача 3 к Уроку 15
 *
 * На форуме есть два типа пользователей – обычные пользователи и администраторы.
 * Пользователи могут читать форум и писать сообщения. Администраторы дополнительно могут удалять сообщения и
 * пользователей.
 *
 * Опиши классы для сущностей пользователей и администраторов, используя абстрактный класс. У абстрактного класса
 * должны быть соответствующие общие поля и методы. Действия на форуме отобрази сообщениями в консоль.
 */
fun main() {

    val user1 = Ordinary("Tom")
    user1.readChat()
    val msg1 = Message(user1, "привет всем")
    user1.sendMessage(msg1)

    val user2 = Ordinary("Jerry")
    user2.readChat()
    val msg2 = Message(user2, "Привет, как ты")
    user2.sendMessage(msg2)

    val user3 = Administrator("Walt")
    user3.readChat()
    val msg3 = Message(user3, "Добрый день. Напоминаю о правилах форума")
    user3.sendMessage(msg3)

    user1.deleteMessage(msg3.id)
    user2.deleteUser(user1.id)

    user3.deleteMessage(msg1.id)
    user3.deleteUser(user2.id)

}

/**
 * Определил скелет системы, но задание требует имитировать действия на форуме сообщениями в консоли, поэтому логику
 * чата и взаимодействие объектов не реализовывал, ограничился только имитацией функционала в классах пользователей.
 */
class Chat {
    val users = mutableListOf<User>()
    val messages = mutableListOf<Message>()
}

class Message(
    val user: User,
    val message: String,
) {
    val id = nextId()

    fun printMessageInfo() {
        println("${user.name}: $message")
    }

    companion object {
        private var idCounter = 0
        private fun nextId() = ++idCounter
    }
}

abstract class User(
    val name: String,
) {
    val id = nextId()

    open fun readChat() {
        println("User \"$name\" (id: $id) read chat messages")
    }

    open fun sendMessage(msg: Message) {
        print("User \"$name\" (id: $id) send message (id: ${msg.id})\n\t")
        msg.printMessageInfo()
    }

    abstract fun deleteMessage(messageId: Int)
    abstract fun deleteUser(userId: Int)

    companion object {
        private var idCounter = 0
        private fun nextId() = ++idCounter
    }
}

class Ordinary(
    name: String,
) : User(name) {

    override fun deleteMessage(messageId: Int) {
        println("User \"$name\" (id: $id) can\'t delete message (id: ${messageId}): Access denied")
    }

    override fun deleteUser(userId: Int) {
        println("User \"$name\" (id: $id) can\'t delete user (id: ${userId}): Access denied")
    }
}

class Administrator(
    name: String,
) : User(name) {

    override fun deleteMessage(messageId: Int) {
        println("User \"$name\" (id: $id) successfully delete message (id: ${messageId})")
    }

    override fun deleteUser(userId: Int) {
        println("User \"$name\" (id: $id) successfully delete user (id: ${userId})")
    }
}
