package lesson_8

/**
 * Задача 5* к Уроку 8
 *
 * Напиши программу, которая должна создавать массив из определенного количества ингредиентов, которые будет вводить
 * пользователь.
 * - элементы вводятся по одному;
 * - перед вводом элементов сначала запрашивается количество планируемых ингредиентов;
 * - запрещено использовать список или динамический массив.
 *
 * Выведи полученные ингредиенты в консоль через запятую.
 */
fun main() {

    var countOfIngredients: Int

    while (true) {
        print("Введите количество ингредиентов в рецепте: ")
        countOfIngredients = readln().toInt()
        if (countOfIngredients > 0)
            break
        println("Количество ингредиентов должно быть положительным!")
    }

    val ingredients = Array<String>(countOfIngredients) { "" }
    for (i in ingredients.indices) {
        print("Введите название ингредиента ${i + 1}: ")
        ingredients[i] = readln()
    }

    println("Список ингредиентов: ${ingredients.joinToString(", ")}")

}