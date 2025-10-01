package lesson_11

/**
 * Задача 1 к Уроку 11
 *
 * Создай класс, который будет хранить данные пользователя. В свойствах должна храниться информация об уникальном
 * идентификаторе, логине, пароле и почте. Названием может быть, например, User. Создай два экземпляра класса с
 * произвольными данными и выведи в консоль содержимое их полей.
 */
class UserCredentials(
    val id: Long,
    val login: String,
    val password: String,
    val email: String,
) {
    fun printFullInfo() {
        println("id: $id, login: $login, password: $password, e-mail: $email")
    }
}

fun main() {

    val userA = UserCredentials(getUniqueId(), "tom", "milk", "tom@disney.com")
    val userB = UserCredentials(getUniqueId(), "jerry", "cheese", "jerry@disney.com")

    userA.printFullInfo()
    userB.printFullInfo()

}

val registeredUserId = MutableList(0) { 0L }

fun getUniqueId(): Long {

    var id: Long

    do {
        id = (0..Long.MAX_VALUE).random()
    } while (id in registeredUserId)
    registeredUserId.add(id)

    return id

}