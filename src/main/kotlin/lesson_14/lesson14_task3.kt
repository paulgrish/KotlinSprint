package lesson_14

/**
 * Задача 3 к Уроку 14
 *
 * Напиши программу для работы с геометрическими фигурами: кругом и прямоугольником. Каждая фигура имеет свой цвет
 * и уникальные параметры:
 * - для круга — радиус;
 * - для прямоугольника — ширину и высоту.
 *
 * Создай абстрактный класс Figure с полем color. Внутри определи два абстрактных метода:
 * - для вычисления площади;
 * - для вычисления периметра.
 *
 * Добавь классы-наследники для вышеупомянутых типов фигур. Реализуй методы для вычисления площади и периметра
 * в каждом из классов-наследников (формулы можно найти в интернете).
 *
 * Создай несколько объектов разных цветов (черные и белые) и сохрани в единый список. Выведи в консоль:
 * - сумму периметров всех черных фигур;
 * - сумму площадей всех белых фигур.
 */
fun main() {

    val figureList = listOf<Figure>(
        Circle(COLOR1, 1.44),
        Rectangle(COLOR1, 2.4, 4.1),
        Circle(COLOR2, 5.0),
        Rectangle(COLOR2, 3.0, 4.0),
    )

    val blackPerimeters = figureList.filter { it.color == COLOR1 }.sumOf { it.perimeter() }
    val whiteSquare = figureList.filter { it.color == COLOR2 }.sumOf { it.square() }

    println("Sum of $COLOR1 figures perimeters: $blackPerimeters")
    println("Sum of $COLOR2 figures squares: $whiteSquare")

}

const val COLOR1 = "black"
const val COLOR2 = "white"

abstract class Figure(
    val color: String,
) {

    abstract fun square(): Double
    abstract fun perimeter(): Double

}

class Circle(
    color: String,
    val radius: Double,
) : Figure(color) {

    override fun square(): Double {
        return Math.PI * radius * radius
    }

    override fun perimeter(): Double {
        return 2.0 * Math.PI * radius
    }

}

class Rectangle(
    color: String,
    val width: Double,
    val height: Double,
) : Figure(color) {

    override fun square(): Double {
        return width * height
    }

    override fun perimeter(): Double {
        return 2.0 * (width + height)
    }

}