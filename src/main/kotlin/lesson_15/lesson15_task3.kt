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

}

class Chat {
    val users = mutableListOf<User>()
    val messages = mutableListOf<Message>()
}

class Message(
    val user: User,
    val message: String,
)

abstract class User(
    val name: String,
)

class Ordinary(
    name: String,
) : User(name)

class Administrator(
    name: String,
) : User(name)
