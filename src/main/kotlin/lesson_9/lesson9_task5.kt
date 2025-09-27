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

    val ingredients = MutableList<String>(INGREDIENTS_COUNT) { "" }
    println("Введите ровно $INGREDIENTS_COUNT неповторяющихся ингредиентов в отдельных строках (через Enter):")
    for (i in ingredients.indices) {
        print("Ингредиент ${i + 1}: ")
        ingredients[i] = readln()
    }

    val uniqueIngredients = ingredients.toSet()
    if (uniqueIngredients.size != INGREDIENTS_COUNT) {
        println("Ингредиенты не должны повторяться!")
        return
    }

    val sortedIngredients: MutableList<String> = ingredients.sorted().toMutableList()
    val firstString = sortedIngredients.first()
    sortedIngredients[0] = firstString.first().uppercase() + firstString.substring(1 until firstString.length)

    println("Вы ввели следующие ингредиенты: " + sortedIngredients.joinToString(", "))

}

const val INGREDIENTS_COUNT = 5