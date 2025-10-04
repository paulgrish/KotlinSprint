package lesson_11

/**
 * Задача 4 к Уроку 11
 *
 * Дизайнер предоставил макет Android-приложения:
 * https://www.figma.com/file/89K5JomHGyIkUFUaBKRBXi/RecipesApp?type=design&node-id=1%3A181&mode=design&t=DsOaqqRfAeCTY2eN-1
 *
 * Для представленных экранов спроектируй следующие сущности для хранения данных:
 * - Категория рецепта
 * - Рецепт
 * - Ингредиент
 */
fun main() {

}

class Category(
    val coverId: Int,
    val caption: String,
) {
    val recipeList = mutableListOf<Recipe>()
}

class Recipe(
    val coverId: Int,
    val caption: String,
    var inFavorites: Boolean = false,
) {
    val ingredientList = mutableListOf<Ingredient>()

}

class Ingredient {

}