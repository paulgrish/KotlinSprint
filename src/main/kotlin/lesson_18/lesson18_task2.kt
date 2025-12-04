package lesson_18

/**
 * Задача 2 к Уроку 18
 *
 * В игре используются типы игральных костей с разным количеством граней: 4, 6 и 8.
 * Опиши их иерархию, создав по классу на каждый тип. У каждой кости должен быть метод, бросающий кость и печатающий
 * значение в консоль.
 *
 * Для демонстрации полиморфизма “включения”:
 * - создай несколько объектов с разными гранями;
 * - собери из них список объектов, указав тип списка;
 * - выполни итерацию по списку и вызови у каждого объекта метод броска кости.
 */
fun main() {
    val dices = listOf<Dice>(
        Tetrahedron(),
        Hexahedron(),
        Octahedron(),
        Octahedron(),
        Hexahedron(),
        Tetrahedron(),
    )
    dices.forEach {
        it.roll()
    }
}

open class Dice(
    val edges: Int,
) {
    fun hit() = (1..edges).random()
    fun roll() = println("Результат броска: ${hit()}")
}

class Tetrahedron : Dice(4)
class Hexahedron : Dice(6)
class Octahedron : Dice(8)
