package lesson_16

/**
 *Задача 1 к Уроку 16
 *
 * На игральном кубике может выпасть одно число от 1 до 6.
 * Создай класс кубика, в котором будет проинициализировано одно поле со случайным числом. Единственный способ узнать
 * это число – вызвать специальный метод, который напечатает информацию в консоль.
 */
fun main() {
    val dice = Dice()
    dice.showValue()
}

class Dice {
    private val value = (DICE_MIN_VALUE..DICE_MAX_VALUE).random()
    fun showValue() {
        println("Dice value is $value")
    }
}

const val DICE_MIN_VALUE = 1
const val DICE_MAX_VALUE = 6
