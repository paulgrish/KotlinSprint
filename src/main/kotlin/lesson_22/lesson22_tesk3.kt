package lesson_22

/**
 * Задача 3 к Уроку 22
 *
 * Используя любой data class, в котором есть минимум 3 свойства, выполни деструктуризацию объекта на отдельные
 * переменные и выведи их значения в консоль.
 */
fun main() {
    val good1 = Good("Kiwi", 43.21f, 56)
    val (name, cost, count) = good1
    println("Found good: \"$name\", $cost rub. x $count pc.")
}

data class Good(val name: String, val cost: Float, val count: Int)