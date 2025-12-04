package lesson_18

/**
 * Задача 3 к Уроку 18
 *
 * В тамагочи есть лиса, собака и кошка. Они могут только есть и спать.
 * Лиса ест ягоды, собака – кости, а кошка – рыбу. У каждого животного есть имя. Эти действия отображаются в консоли
 * по такому шаблону: “\[имя] -> \[действие]”.
 *
 * – опиши эти классы, используя полиморфизм;
 * – создай по одному объекту животного, сохрани их в список с принудительным указанием типа списка;
 * – в цикле вызывай метод приема пищи для каждого экземпляра.
 */
fun main() {
    val pets = listOf<Tamagochi>(
        Fox("Тама-тама"),
        Dog("Шарик"),
        Cat("Матроскин")
    )
    pets.forEach {
        it.eat()
    }
    pets.first().sleep()
}

open class Tamagochi(
    val name: String,
    val food: String,
) {
    open fun eat() {
        println("$name (${this::class.simpleName}) -> ест $food")
    }
    open fun sleep() {
        println("$name (${this::class.simpleName}) -> спит")
    }
}

class Fox(name: String) : Tamagochi(name, "ягоды")
class Dog(name: String) : Tamagochi(name, "кости")
class Cat(name: String) : Tamagochi(name, "рыбу")