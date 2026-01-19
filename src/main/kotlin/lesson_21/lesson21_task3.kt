package lesson_21

import kotlin.math.*

/**
 * Задача 3 к Уроку 21
 *
 * Создай класс игрока, который аналогичен классу Player из задания 20-2. Помимо имени у игрока должны быть поля
 * с текущим и максимальным здоровьем. Предположим, что у нас нет возможности редактировать класс (нельзя добавлять
 * новые функции в класс Player).
 *
 * Требуется реализовать функцию-расширение isHealthy для этого класса, которая будет возвращать true, если
 * здоровье игрока равно максимальному здоровью, и false в противном случае.
 */
fun main() {

    val potion = { player: Player ->
        player.health = player.maxHealth
    }

    val player = Player("John", 78)

    player.healthReport()
    potion(player)
    player.healthReport()
}

class Player(
    val name: String,
    currentHealth: Int,
    val maxHealth: Int = MAX_HEALTH,
) {
    var health = currentHealth
        set(value) {
            field = max(0, min(maxHealth, value))
        }

    fun healthReport() = println("Текущее здоровье игрока $name: $health/$maxHealth")
}

const val MAX_HEALTH = 100