package lesson_13.task3

/**
 * Задача 3 к Уроку 13
 *
 * Скопируй класс из предыдущей задачи и измени его название для избегания конфликтов.
 *
 * Для того, чтобы взаимодействовать со всеми записями телефонной книги, как с одним целым, их нужно объединить
 * в список.
 * - создай и инициализируй (одновременно) список с 5 объектами класса-контакта;
 * - 2 контакта должны принимать null для поля компании;
 * - 1 контакт должен иметь название компании “null”;
 * - выведи список всех существующих компаний, которые есть в телефонной книге.
 */
fun main() {

    val contactList = listOf(
        Contact3("Tom", 9876543210L, "Disney"),
        Contact3("Jerry", 9876543012L, "Disney"),
        Contact3("Spike", 9012345678L, "null"),
        Contact3("paul", 9222535881L),
        Contact3("gri", 9222770770L),
    )

    contactList.forEachIndexed { i, it ->
        println("Контакт ${i + 1}:")
        it.print()
    }
}

class Contact3(
    val name: String,
    val phone: Long,
    val company: String? = null,
) {
    fun print() {
        println("- Имя: $name\n- Номер: $phone\n- Компания: ${company ?: "$NULL_COMPANY_VALUE"}")
    }
}

const val NULL_COMPANY_VALUE = "<не указано>"