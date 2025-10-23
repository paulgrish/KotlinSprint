package lesson_15

/**
 * Задача 1 к Уроку 15
 *
 * В мобильной игре есть разные существа. Напиши интерфейсы для летающих и плавающих существ.
 * - создай интерфейсы с методами передвижения для: карась, чайка, утка;
 * - создай для каждого существа классы, реализующие соответствующие интерфейсы;
 * - выведи сообщения в консоль, о том как они могут передвигаться.
 */
fun main() {

    val carp = Carp()
    carp.move()

    val seagull = Seagull()
    seagull.move()

    val duck = Duck()
    duck.move()

}

interface Swimable {
    fun toSwim()
}

interface Flyable {
    fun toFly()
}

abstract class Creature(
    val name: String
) {
    abstract fun move()
}

class Carp() : Creature("Карась"), Swimable {
    override fun move() {
        toSwim()
    }

    override fun toSwim() {
        println("$name плавает в воде")
    }
}

class Seagull(): Creature("Чайка"), Flyable {
    override fun move() {
        toFly()
    }

    override fun toFly() {
        println("$name летает")
    }
}

class Duck(): Creature("Утка"), Swimable, Flyable {
    override fun move() {
        toSwim()
        toFly()
    }

    override fun toSwim() {
        println("$name плавает по воде")
    }

    override fun toFly() {
        println("$name летает")
    }
}