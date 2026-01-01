package lesson_20

import kotlin.math.*

/**
 * Задача 2 к Уроку 20
 *
 * В компьютерной игре игрок может подобрать лечебное зелье, которое восстанавливает всё его здоровье. Для реализации
 * программы понадобится создать простой класс игрока (у него должно быть имя, текущее и максимальное здоровье).
 * – Напиши лямбда-функцию с явным указанием типа переменной, реализующую лечебное зелье. Функция должна принимать в
 * качестве параметра объект игрока.
 * – Создай экземпляр игрока с неполным здоровьем, примени к нему созданную лямбду-функцию.
 */
fun main() {

    val potion = { gamer: Gamer ->
        gamer.health = gamer.maxHealth
    }

    val gamer = Gamer("John", 78)

    gamer.healthReport()
    potion(gamer)
    gamer.healthReport()
}

class Gamer(
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