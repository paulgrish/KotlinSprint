package lesson_19

/**
 * Задача 5* к Уроку 19
 *
 * Разрабатываем приложение “Картотека”. Пользователь вводит имя и пол человека. Данные картотеки хранятся в списке.
 * Человека описывает класс, содержащий имя и пол. Пол должен храниться в enum. После ввода 5 человек, список выводится
 * в консоль.
 * При старте приложения печатается инструкция в каком формате вводить имя и пол (и какие значения полов доступны).
 */
fun main() {
    val cards = mutableListOf<Person>()

    println("Введите данные $ENTRIES_COUNT человек.")


    cards.add(Person("Анна", Sex.FEMALE))
    cards.add(Person("Петр", Sex.MALE))
    cards.add(Person("Иван", Sex.MALE))

    cards.forEach {
        it.printInfo()
    }
}

class Person(
    val name: String,
    val sex: Sex,
) {
    fun printInfo() {
        println("$name, пол: ${sex.layoutName}")
    }
}

enum class Sex(
    val layoutName: String,
    private val validChars: List<Char>
) {
    MALE("Мужской", listOf('м', 'm')),
    FEMALE("Женский", listOf('ж', 'f'));

    fun printInstruction() {
        println("Для ввода пола укажите один символ (в любом регистре):")
        entries.forEach {
            it.printItemInstruction()
        }
    }

    fun machChar(c: Char): Boolean {
        return c.lowercaseChar() in validChars
    }

    fun printItemInstruction() {
        print("${layoutName}: ")
        println(validChars.joinToString {
            "\'" + it + "\'" + (
                    if (it in 'а'..'я')
                        " (кириллица)"
                    else
                        " (ANSI)")
        })
    }
}

const val ENTRIES_COUNT = 5