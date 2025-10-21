package lesson_14.task_2

/**
 * Задача 2 к Уроку 14
 *
 * Скопируй классы из предыдущей задачи и измени их названия для избегания конфликтов.
 *
 * Каждый тип корабля обладает уникальным способом погрузки:
 * - лайнер выдвигает горизонтальный трап со шкафута;
 * - грузовой корабль активирует погрузочный кран;
 * - ледокол открывает ворота со стороны кормы.
 *
 * Реализуй методы погрузки, специфичные для каждого вида корабля.
 * Добавь метод вывода информации о свойствах корабля и выведи информацию в консоль.
 */
fun main() {

    val linear1 = Linear()
    linear1.printShipInfo()
    linear1.loading()
    println()

    val cargo1 = Cargo()
    cargo1.printShipInfo()
    cargo1.loading()
    println()

    val icebreaker1 = Icebreaker()
    icebreaker1.printShipInfo()
    icebreaker1.loading()
    println()

}

open class Linear(
    val speed: Int = 30, /* узлов */
    val cargo: Int = 500, /* тонн */
    val passengers: Int = 7200,
    val icebreaking: Boolean = false,
) {
    fun printShipInfo() {
        print(
            "Ship type: ${this::class.simpleName}\n- Speed: $speed knots\n" +
                    "- Cargo: $cargo tons\n- Passengers: $passengers\n" +
                    if (icebreaking) "- Is icebreaker\n" else ""
        )
    }

    open fun loading() {
        println("Extend the horizontal ramp.")
    }
}

class Cargo(
    speed: Int = 20,
    cargo: Int = 10000,
    passengers: Int = 20,
) : Linear(speed, cargo, passengers) {
    override fun loading() {
        println("Activate the loading crane.")
    }
}

class Icebreaker(
    speed: Int = 10,
    cargo: Int = 5000,
    passengers: Int = 10,
    icebreaking: Boolean = true,
) : Linear(speed, cargo, passengers, icebreaking) {
    override fun loading() {
        println("Open the gate from the stern.")
    }
}