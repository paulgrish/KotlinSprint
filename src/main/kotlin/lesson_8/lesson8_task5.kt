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

    val ingredients = Array<String>(10) { "" }

    println("Список ингредиентов:\n" +
                ingredients.joinToString("\n- ", "- ", "\n")
    )

    print("Какой ингредиент надо заменить: ")
    val wantedIngredient = readln()

    if (wantedIngredient in ingredients) {
        print("Какой ингредиент вместо \"$wantedIngredient\" надо добавить: ")
        ingredients[ingredients.indexOf(wantedIngredient)] = readln()
        println("Готово! Вы сохранили следующий список:\n" +
                    ingredients.joinToString("\n- ", "- ", "\n")
        )
    } else {
        println("Такого ингредиента в рецепте нет")
    }

}