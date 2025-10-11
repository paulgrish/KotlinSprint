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
    var proceed = true

    while (proceed) {
        println("Введите данные контакта:")
        print("- Имя: ")
        val name = readln().trim()
        print("- Номер (только цифры): ")
        val phone = readln().trim().toLongOrNull()
        print("- Компания (пустая строка, если не задано): ")
        val company = readln().trim()

        if (phone != null && !name.isBlank()) {
            contactList.add(
                Contact4(
                    name,
                    phone,
                    company.ifBlank { null }
                )
            )
            println("Запись успешно добавлена.")
        } else {
            println("Запись должна содержать имя и корректный номер телефона!")
        }

        while (true) {
            println("Добавить еще одну запись? (да/нет)")
            val answer = readln().trim().lowercase()
            when (answer) {
                "да" -> {
                    break
                }
                "нет" -> {
                    proceed = false
                    break
                }
                else -> {
                    println("Введите только \"да\" или \"нет\"")
                }
            }
        }
    }

    println("Список контактов:")
    if (contactList.isNotEmpty()) {
        contactList.forEachIndexed { i, it ->
            println("Контакт ${i + 1}:")
            it.printContactInfo()
        }
    } else {
        println("<пусто>")
    }
}

class Contact4(
    val name: String,
    val phone: Long,
    val company: String? = null,
) {
    fun printContactInfo() {
        println("- Имя: $name\n- Номер: $phone\n- Компания: ${company ?: NULL_COMPANY_TEXT}")
    }
}

const val NULL_COMPANY_TEXT = "<не указано>"