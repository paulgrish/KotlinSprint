package lesson_18

/**
 * Задача 5* к Уроку 18
 *
 * В приложении есть экран, на котором можно рисовать различные фигуры, указывая координаты (x, y). Фигурами могут
 * быть круг, квадрат и точка. Координаты могут быть представлены типами данных Int и Float.
 *
 * Создайте класс Screen, который будет содержать методы draw для рисования каждой фигуры с координатами типов
 * Int и Float. Каждый метод должен возвращать строку, указывающую, какая фигура нарисована и в каких координатах.
 * Используйте перегрузку методов для реализации.
 */
fun main() {
    val s = Screen()
    println(s.draw(7, 8))
    println(s.draw(1, 2, 3))
    println(s.draw(5, 2, 4, 6))
    println(s.draw(-1.2f, -3.4f))
    println(s.draw(7.6f, 5.4f, 3.2f))
    println(s.draw(2.3f, -4.5f, 6.7f, 8.9f))
}

class Screen {
    fun draw(x: Int, y: Int) = "Point at ($x; $y)"
    fun draw(x: Int, y: Int, r: Int) = "Circle at ($x; $y), radius $r"
    fun draw(x: Int, y: Int, w: Int, h: Int) = "Circle at ($x; $y), width $w, height $h"
    fun draw(x: Float, y: Float) = "Point at ($x; $y)"
    fun draw(x: Float, y: Float, r: Float) = "Circle at ($x; $y), radius $r"
    fun draw(x: Float, y: Float, w: Float, h: Float) = "Circle at ($x; $y), width $w, height $h"
}