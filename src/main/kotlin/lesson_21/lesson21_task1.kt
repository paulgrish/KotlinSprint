package lesson_21

/**
 * Задача 1 к Уроку 21
 *
 * Реализуй extension функцию для класса String, которая будет возвращать количество гласных букв в строке.
 * Назови функцию vowelCount. Например, для строки "hello" функция должна вернуть 2.
 */
fun main() {
    val strings = listOf(
        "Hello",
        "Привет!",
        "Назови функцию vowelCount.",
    )

    for (str in strings) {
        println("В строке \"$str\" гласных ${str.vowelCount()}")
    }
}

fun String.vowelCount(): Int {
    val vowels = setOf(
        'a', 'e', 'i', 'o', 'u', 'y',
        'A', 'E', 'I', 'O', 'U', 'Y',
        'а', 'е', 'ё', 'и', 'о', 'у', 'ы', 'э', 'ю', 'я',
        'А', 'Е', 'Ё', 'И', 'О', 'У', 'Ы', 'Э', 'Ю', 'Я',
    )
    return count { it in vowels }
}