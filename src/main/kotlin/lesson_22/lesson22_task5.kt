package lesson_22

import java.util.Date

/**
 * Задача 5* к Уроку 22
 *
 * В Путеводитель для путешествующих автостопом по Галактике добавляется информация о месте или событии в галактике
 * в виде объектов.
 * Создай data class GalacticGuide cо свойствами:
 * - название места или события;
 * - описание места или события;
 * - дата и время события;
 * - расстояние места или события от Земли в световых годах.
 *
 * Создай объект с информацией о звездной системе Alpha Centauri. Выведи информацию о месте, используя компонентные
 * функции data class.
 */
fun main() {
    val record1 = GalacticGuide(
        "Alpha Centauri",
        "Тройная звездная система, ближайшая до Земли",
        Date(2026, 1, 24, 22, 14, 18),
        4.36f
    )
    println("Запись 1: Информация о месте:")
    println(record1.component1())
    println(record1.component2())
    println(record1.component3())
    println(record1.component4())
}

data class GalacticGuide(
    val name: String,
    val description: String,
    val dateTime: Date,
    val distance: Float,
)