package lesson_11.task_3

/**
 * Задача 3 к Уроку 11
 *
 * Прокачиваем абстрактное мышление. Задача на проектирование сущностей для упрощенной версии приложения социальной
 * сети, в которой общаются только голосом. Требуется описать сущности и имитировать действия методами.
 *
 * Функционал одного из модулей будет такой. Есть лента, в которой отображаются “комнаты” для общения по интересам.
 * В карточке “комнаты” отображается:
 * - обложка;
 * - название;
 * - список участников — отображаются в виде аватарок. При долгом нажатии на аватар подсветится его никнейм. Рядом с
 * аватаркой отображается текстовый бейдж с одним из возможных статусов говорящего: “разговаривает”,
 * “микрофон выключен”, “пользователь заглушен”.
 *
 * Класс должен содержать методы:
 * – добавления участника (принимает объект участника и сохраняет в свойство комнаты);
 * – обновления статуса (принимает имя пользователя и новый статус).
 *
 * После проектирования создай объект комнаты с произвольными данными.
 */
class ChatRoom(
    val cover: Int,
    val caption: String,
) {
    val users: MutableList<ChatUser> = mutableListOf<ChatUser>()

    fun addUser(user: ChatUser) {
        if (users.none { it.nickname == user.nickname }) {
            users.add(user)
        }
    }

    fun updateUserStatus(userNickname: String, statusLevel: String) {
        users.find { it.nickname == userNickname }.also {
                it.status = statusLevel
        }
    }
}

const val USER_STATUS_TALK = "разговаривает"
const val USER_STATUS_SILENT = "микрофон выключен"
const val USER_STATUS_DISABLE = "пользователь заглушен"

class ChatUser(
    val avatarId: Int,
    val nickname: String,
    var status: String,
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
