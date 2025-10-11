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
    println("Введите данные контакта:")
    print("- Имя: ")
    val name = readln().trim()
    print("- Номер (только цифры): ")
    val phoneStr = readln().trim()
    print("- Компания (пустая строка, если не задано): ")
    val company = readln().trim()
    var phone: Long

    try {
        phone = phoneStr.toLong()
    } catch (e: NumberFormatException) {
        println("Номер введен неправильно, ошибка \"${e::class.simpleName}\"")
        return
    }

    val contact = Contact5(
        name,
        phone,
        company.ifBlank { null }
    )

    println("Введен контакт:")
    contact.printContactInfo()

}

class Contact5(
    val name: String,
    val phone: Long,
    val company: String? = null,
) {
    fun printContactInfo() {
        println("- Имя: $name\n- Номер: $phone\n- Компания: ${company ?: NULL_COMPANY_TEXT}")
    }
}

const val NULL_COMPANY_TEXT = "<не указано>"