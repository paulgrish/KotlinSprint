package lesson_11

/**
 * Задача 5* к Уроку 11
 *
 * Реализовать класс работы форума (Forum). Для реализации создай дополнительные классы для сущностей “Член форума”
 * (с полями userId и userName) и “Сообщение форума” (с полями authorId и message).
 *
 * Примени паттерн “Строитель” для создания пользователей и сообщений форума. Напрямую объекты не создаются, логика
 * должна быть инкапсулирована внутри методов класса.
 * - createNewUser() создает новых пользователей, принимая имя пользователя. Метод сохраняет нового пользователя в
 * общий список и одновременно возвращает новый объект. Генерация id-шников новых пользователей происходит внутри;
 * - createNewMessage() создает сообщения, принимая id пользователя. Сообщения создаются только если такой пользователь
 * есть на форуме;
 * - printThread() печатает в консоль все сообщения добавленные на форум в формате:
 *     автор: сообщение
 *     автор: сообщение
 *
 * Создай экземпляр Forum и продемонстрируй его работу, добавив двух пользователей и по два сообщения от каждого
 * пользователя.
 */
fun main() {

    val forum = Forum()

    val user1 = forum.createNewUser("Tom")
    val user2 = forum.createNewUser("Jerry")

    forum.createNewMessage(user1.userId, "Привет! А я сейчас в гостях сижу, прикинь)")
    forum.createNewMessage(user2.userId, "Здарова! Это круто! А у кого сидишь?")
    forum.createNewMessage(user1.userId, "У тебя)")
    forum.createNewMessage(user2.userId, "Ой ё...")

    forum.printThread()

}

class Forum {

    val members = mutableListOf<Member>()
    val thread = mutableListOf<Message>()

    fun createNewUser(userName: String): Member {
        members.add(
            Member.Builder()
                .userName(userName)
                .build()
        )
        return members.last()
    }

    fun createNewMessage(authorId: Long, message: String) {
        thread.add(
            Message.Builder()
                .authorId(authorId)
                .message(message)
                .build()
        )
    }

    fun printThread() {
        if (thread.size > 0) {
            thread.forEach {
                val id = it.authorId
                println("${members.find { it.userId == id }?.userName ?: "[неизвестен]"} ($id): ${it.message}")
            }
        } else {
            println("[сообщений нет]")
        }

    }

}

class Member private constructor(
    val userId: Long,
    val userName: String,
) {
    class Builder {
        private var userName: String = "(noname)"

        fun userName(userName: String): Builder {
            this.userName = userName
            return this
        }

        fun build() = Member(IdGenerator.next(), userName)
    }
}

class Message private constructor(
    val authorId: Long,
    val message: String,
) {
    class Builder {
        private var authorId: Long = 0L
        private var message: String = ""

        fun authorId(authorId: Long): Builder {
            this.authorId = authorId
            return this
        }

        fun message(message: String): Builder {
            this.message = message
            return this
        }

        fun build() = Message(authorId, message)
    }
}

class IdGenerator {

    companion object {
        var idCounter = 0L
        fun next() = ++idCounter
    }

}