package lesson_13.task5

/**
 * Задача 5* к Уроку 13
 *
 * Скопируй класс из предыдущей задачи (без логики заполнения телефонной книги) и измени его название для избегания
 * конфликтов.
 * Для получения номера программа считывает ввод пользователя с типом String по умолчанию. Приведи строку к типу Long.
 * Если пользователь ввел что-либо, кроме цифр — программа падает.
 * Необходимо избежать падения программы при попытке приведения строки к типу Long. Отлови ошибку и выведи ее название
 * в консоль.
 */
fun main() {

    val contactList = mutableListOf<Contact4>()
    var name: String
    var phone: Long?
    var company: String?
    var answer: String
    var proceed = true

    while (proceed) {

        println("Введите данные контакта:")
        print("- Имя: ")
        name = readln().trim()
        print("- Номер (только цифры): ")
        phone = readln().trim().toLongOrNull()
        print("- Компания (пустая строка, если не задано): ")
        company = readln().trim()

        if (phone != null && !name.isBlank()) {
            contactList.add(
                Contact4(
                    name,
                    phone,
                    if (company.isBlank()) null else company
                )
            )
            println("Запись успешно добавлена.")
        } else {
            println("Запись должна содержать имя и корректный номер телефона!")
        }

        while (true) {
            println("Добавить еще одну запись? (да/нет)")
            answer = readln().trim().lowercase()
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