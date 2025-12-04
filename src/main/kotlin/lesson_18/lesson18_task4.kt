package lesson_18

/**
 * Задача 4 к Уроку 18
 *
 * В программе хранятся данные о посылках. Нужно написать иерархию классов, описывающих коробки. Чтобы рассчитывать
 * упаковку для посылок, в классе должен быть метод, возвращающий площадь поверхности посылки.
 *
 * Если посылка прямоугольная, она должна создаваться с длиной, шириной и высотой. Если посылка – куб, то только с
 * длиной ребра.
 */
fun main() {
    val boxes = listOf<Box>(
        ParallelogramBox(2f, 3f, 4f),
        ParallelogramBox(1.5f, 2.5f, 3.5f),
        CubeBox(2f),
        CubeBox(1.5f),
    )
    boxes.forEach {
        println("${it::class.simpleName}: Square = ${it.square()}")
    }
}

abstract class Box {
    abstract fun square(): Float
}

class ParallelogramBox(
    val width: Float,
    val height: Float,
    val depth: Float,
) : Box() {
    override fun square(): Float = 2 * (width * height + height * depth + depth * width)
}

class CubeBox(
    val edge: Float,
) : Box() {
    override fun square(): Float = 6 * edge * edge
}