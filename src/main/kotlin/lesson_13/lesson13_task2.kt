package lesson_13

/**
 *Задача 2 к Уроку 13
 *
 * Скопируй класс из предыдущей задачи и измени его название для избегания конфликтов.
 * На его основе создай экземпляр. Для поля с названием компании значение по умолчанию должно быть null.
 * Дополни класс методом, который будет печатать информацию о контакте сообщением в одном println() и без
 * использования многострочного ввода такого типа (пример):
 * - Имя: Ростислав
 * - Номер: 89123456789
 * - Компания: Reddit
 * Вместо null значения, в консоль должна выводиться строка <не указано>.
 */
fun main() {

    println("Введите данные контакта:")
    print("- Имя: ")
    val name = readln()
    print("- Номер: ")
    val phone = readln().toLong()
    print("- Компания (пустая строка или \"$NULL_COMPANY_VALUE\", если не задано): ")
    val company = readln()

    val contact = Contact2(
        name,
        phone,
        if (company != NULL_COMPANY_VALUE && company != EMPTY_COMPANY_VALUE) company else null
    )

    println("Информация о контакте:")
    contact.print()
}

class Contact2(
    val name: String,
    val phone: Long,
    val company: String? = null,
) {
    fun print() {
        println("- Имя: $name\n- Номер: $phone\n- Компания: ${company ?: "<не указано>"}")
    }
}

const val NULL_COMPANY_VALUE = "<не указано>"
const val EMPTY_COMPANY_VALUE = ""