package lesson_21

/**
 * Задача 2 к Уроку 21
 *
 * Создайте extension функцию evenNumbersSum для списка целых чисел, которая будет возвращать сумму всех четных
 * чисел в списке. Четными считаются числа, которые делятся на 2 без остатка.
 */
fun main() {
    listOf(
        listOf(1, 2, 3, 4, 5),
        listOf(1, 3, 5),
        listOf(2),
    ).forEach {
        println("Для списка $it сумма четных равна ${it.evenNumbersSum()}")
    }
}

fun List<Int>.evenNumbersSum(): Int {
    return this.filter {
        it % 2 == 0
    }.sum()
}