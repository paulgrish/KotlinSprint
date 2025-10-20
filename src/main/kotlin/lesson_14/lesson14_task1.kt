package lesson_14

/**
 * Задача 1 к Уроку 14
 *
 * В компьютерной игре есть три типа судов: лайнер, грузовой и ледокол. Все суда основаны на базовом классе лайнера,
 * но каждый из них имеет свой функционал и дополнительные свойства.
 * - У грузовых судов скорость меньше, но грузоподъемность больше.
 * - У ледоколов ниже и скорость, и вместительность, но они могут колоть лёд.
 * - Лайнеры могут вмещать наибольшее количество пассажиров.
 *
 * Спроектируй иерархию классов, задав значения по умолчанию в конструкторе базового класса. Отнаследованные классы
 * должны переопределять необходимые свойства. Создай по одному экземпляру каждого типа судна.
 */
fun main() {

    val linear1 = Linear()
    linear1.printShipInfo()

    val cargo1 = Cargo()
    cargo1.printShipInfo()

    val icebreaker1 = Icebreaker()
    icebreaker1.printShipInfo()

}

open class Linear(
    val speed: Int = 30, /* узлов */
    val cargo: Int = 500, /* тонн */
    val passengers: Int = 7200,
    val icebreaking: Boolean = false,
) {
    fun printShipInfo() {
        println(
            "Ship type: ${this::class.simpleName}\n- Speed: $speed knots\n" +
                    "- Cargo: $cargo tons\n- Passengers: $passengers\n" +
                    if (icebreaking) "- Is icebreaker\n" else ""
        )
    }
}

class Cargo(
    speed: Int = 20,
    cargo: Int = 10000,
    passengers: Int = 20,
) : Linear(speed, cargo, passengers)

class Icebreaker(
    speed: Int = 10,
    cargo: Int = 5000,
    passengers: Int = 10,
    icebreaking: Boolean = true,
) : Linear(speed, cargo, passengers, icebreaking)