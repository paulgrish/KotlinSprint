package lesson_11.task_2

/**
 * Задача 2 к Уроку 11
 *
 * Скопируй класс User из первой задачи и назови User2.
 * Добавь к классу новое необязательное свойство bio и несколько методов:
 * - вывод информации о пользователе в консоль;
 * - считывание из консоли текста и запись в поле bio;
 * - изменение пароля — сначала запросить текущий пароль, и, если он введен верно, запросить новый. Записать его в
 * поле и сообщить, что пароль изменен;
 *
 * Далее создай объект, заполни информацию “о себе” и замени пароль. В конце выведи обновленную информацию о
 * пользователе.
 */
class User2(
    val id: Long,
    val login: String,
    var password: String,
    val email: String,
    var bio: String = "",
) {

    fun printFullInfo() {
        println("id: $id, login: $login, password: $password, e-mail: $email${if (bio.length > 0) ", bio: $bio" else ""}")
    }

    fun setBioFromConsole() {
        println("Enter additional info for user \'$login\' (id: $id):")
        bio = readln()
    }

    /**
     * return true if password changed successfully, else false
     */
    fun changePassword(): Boolean {

        println("You request for change password for user \'$login\' (id: $id).")

        print("Please, enter current password: ")
        val currentPassword = readln()
        if (currentPassword != password) {
            println("Current password is incorrect!")
            return false
        }

        print("Please, enter new password: ")
        password = readln()
        println("Password for user \'$login\' (id: $id) changed successfully.")

        return true
    }
}

fun main() {


    println("Enter info aboutyourself.")
    print("login: ")
    val userLogin = readln()
    print("password: ")
    val userPassword = readln()
    print("e-mail: ")
    val userEmail = readln()

    val user = User2(getUniqueId(), userLogin, userPassword, userEmail)
    println("New user created:")
    user.printFullInfo()

    user.setBioFromConsole()

    user.changePassword()

    println("Updated user data:")
    user.printFullInfo()

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