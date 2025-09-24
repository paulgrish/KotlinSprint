package lesson_8

/**
 * Задача 3 к Уроку 8
 *
 * Используй условие из предыдущей задачи. Нужно доработать код, который проверяет наличие ингредиента в рецепте.
 * Однако, не используя цикл для поиска.
 */
fun main() {

    // сырники)
    val ingredients = arrayOf("творог", "яйцо", "манка", "соль", "сахар", "сода", "мука", "ванилин")

    print("Какой ингредиент надо найти: ")
    val wantedIngredient = readln()

    val index = ingredients.indexOf(wantedIngredient)
    if (index >= 0)
        println("Ингредиент \"${ingredients[index]}\" в рецепте есть")
    else
        println("Такого ингредиента в рецепте нет")

}