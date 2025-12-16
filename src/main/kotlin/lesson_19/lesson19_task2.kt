package lesson_19

/**
 * Задача 2 к Уроку 19
 *
 * В интернет-магазине товары делятся на несколько категорий: одежда, канцелярские товары и разное.
 *
 *  – создай enum класс с категориями;
 *  – создай метод внутри enum, который вернет текстовое название категории для пользователя;
 *  – создай класс, описывающий товар (с полями название, id, категория), в классе должен быть метод, который выводит
 *  инфо о товаре. Вызови его для нескольких созданных товаров;
 *  – для вывода информации о товаре, для категории используй метод определения категории.
 */
fun main() {
    val goods = listOf(
        Good("Шапка вязанная черная", 48, Category.CLOTHES),
        Good("Ластик 2х1.5", 12, Category.STATIONERY),
        Good("Сметана 15%", 333, Category.OTHER),
        Good("Футболка с принтом XXL", 7514, Category.CLOTHES),
        Good("Набор карандашей 12 цв.", 159, Category.STATIONERY),
        Good("Машинка Мозератти 1:43", 143, Category.OTHER),
    )
    goods.forEach {
        it.printInfo()
    }
}

class Good(
    val name: String,
    val id: Int,
    val category: Category,
) {
    fun printInfo() {
        println("Информация о товаре: $name, id: $id, категория: ${category.getName()}")
    }
}

enum class Category {
    CLOTHES,
    STATIONERY,
    OTHER;
    
    fun getName(): String {
        return when(this) {
            CLOTHES -> "Одежда"
            STATIONERY -> "Канцтовары"
            OTHER -> "Разное"
        }
    }
}