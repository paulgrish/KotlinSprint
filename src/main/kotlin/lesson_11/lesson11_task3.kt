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
fun main() {

    val room = ChatRoom(28, "Disney room")

    room.printRoomCard()

    println()

    room.addUser(ChatUser(1, "Tom"))
    room.addUser(ChatUser(2, "Jerry"))
    room.addUser(ChatUser(3, "Walt", USER_STATUS_TALK))
    room.addUser(ChatUser(4, "Spike"))

    room.printRoomCard()

    println()

    room.updateUserStatus("Jerry", USER_STATUS_DISABLED)
    room.updateUserStatus("Cat", USER_STATUS_TALK)

    room.longPress(0)
    room.longPress(1)
    room.longPress(2)
    room.longPress(3)

}

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
        users.find { it.nickname == userNickname }?.also {
            it.status = statusLevel
        }
    }

    fun printRoomCard() {
        println("[Cover $cover] $caption")
        if (users.size > 0) {
            users.forEach { it.printShortInfo() }
        } else {
            println("[в комнате никого нет]")
        }
    }

    fun longPress(itemIndex: Int) {
        users[itemIndex].printFullInfo()
    }
}

const val USER_STATUS_TALK = "разговаривает"
const val USER_STATUS_SILENT = "микрофон выключен"
const val USER_STATUS_DISABLED = "пользователь заглушен"

class ChatUser(
    val avatarId: Int,
    val nickname: String,
    var status: String = USER_STATUS_SILENT,
) {

    fun printShortInfo() {
        println("[Avatar ${avatarId}]")
    }

    fun printFullInfo() {
        println("[Avatar ${avatarId}] $nickname - $status")
    }

}
