package lesson_9

/**
 * Задача 5* к Уроку 9
 *
 * Напиши программу, которая запрашивает у пользователя пять названий ингредиентов (каждый по отдельности).
 * - результат должен исключать повторы;
 * - список должен выводиться в алфавитном порядке;
 * - все элементы списка выведены в одну строку, разделяя слова запятыми;
 * - первый элемент должен быть распечатан с заглавной буквы.
 */
fun main() {

    println("Введите ровно $COUNT_OF_INGREDIENTS ингредиентов через запятую с пробелом:")
    val ingredients = readln().split(", ").filter { it.length > 0 }

    if (ingredients.size != COUNT_OF_INGREDIENTS) {
        println("Надо было ввести ровно $COUNT_OF_INGREDIENTS ингредиентов (разделяя их запятой с пробелом).")
        return
    }

    val sortedIngredients = ingredients.sorted()

    println("Вы ввели следующие ингредиенты:")
    sortedIngredients.forEach {
        println("- $it")
    }
}

const val COUNT_OF_INGREDIENTS = 5