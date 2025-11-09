package lesson_16

import kotlin.math.*

/**
 * Задача 5* к Уроку 16
 *
 * Для игры требуется создать класс игрока. С полями: имя, здоровье и сила удара. Здоровье должно изменяться только
 * через методы получения урона и лечения.
 *
 * Добавить приватный метод, который вызывается, если при получении урона заканчивается здоровье. Смерть обнуляет
 * силу удара, здоровье и не позволяет лечиться.
 *
 * Сымитируй бой, вызвав несколько раз методы урона и лечения. В конце игрок должен умереть.
 */
fun main() {
    val gamer = Gamer("Bob")
    gamer.printInfo()
    gamer.damage(30)
    gamer.printInfo()
    gamer.cure(50)
    gamer.printInfo()
    gamer.damage(27)
    gamer.printInfo()
    gamer.damage(54)
    gamer.printInfo()
    gamer.cure(50)
    gamer.printInfo()
    gamer.damage(50)
    gamer.printInfo()
    gamer.damage(50)
    gamer.printInfo()
    gamer.cure(99)
    gamer.printInfo()
    gamer.damage(50)
    gamer.printInfo()
}

class Gamer(
    val name: String,
) {
    private var health = MAX_HEALTH
    private var force = MAX_FORCE
    private var alive = true

    private fun toDie(){
        health = 0
        force = 0
        alive = false
    }

    fun damage(points: Int) {
        health = max(health - points, 0)
        if (alive && health == 0)
            toDie()
    }

    fun cure(points: Int) {
        if (alive) {
            health = min(health + points, MAX_HEALTH)
        }
    }

    fun printInfo() {
        println("Игрок \"$name\":\n\tЗдоровье: $health\n\tСила: $force\n\tСтатус: " + if (alive) "жив" else "мертв")
    }
}

const val MAX_HEALTH = 100
const val MAX_FORCE = 100