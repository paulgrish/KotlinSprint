package lesson_13.task4

/**
 * Задача 4 к Уроку 13
 *
 * Скопируй класс из предыдущей задачи и измени его название для избегания конфликтов.
 *
 * Программа должна заполнять контакты в телефонную книгу (отдельный список объектов).
 * - если пользователь не ввел номер телефона, то нужно уведомить об этом пользователя и такая запись не должна добавляться;
 * - для приведения введенного номера к числу используй toLongOrNull();
 * - если пользователь не заполнил компанию, то в объект записывать null.
 *
 * Выведи созданные объекты в консоль методом класса.
 */
fun main() {

    val contactList = mutableListOf<Contact4>()
    var answer: String

    contactList.forEachIndexed { i, it ->
        println("Контакт ${i + 1}:")
        it.print()
    }
}

class Contact4(
    val name: String,
    val phone: Long,
    val company: String? = null,
) {
    fun print() {
        println("- Имя: $name\n- Номер: $phone\n- Компания: ${company ?: "$NULL_COMPANY_VALUE"}")
    }
}

const val NULL_COMPANY_VALUE = "<не указано>"