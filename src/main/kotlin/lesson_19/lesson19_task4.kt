package lesson_19

/**
 * Задача 4 к Уроку 19
 *
 * В компьютерной игре танк может подбирать разные виды патронов. Патроны различаются силой удара.
 * Синие – 5 единиц,
 * зеленые – 10,
 * красные – 20.
 * – создай enum класс для патронов и класс танка. У танка должны быть методы вооружения новым типом патронов и
 * выстрела. При выстреле в консоль должен выводиться нанесенный урон;
 * – создай экземпляр танка и “произведи” несколько выстрелов разными патронами;
 * – экземпляр танка при создании ничем не заряжен;
 * – в решении должен использоваться enum.
 */
fun main() {
    val tank = Tank()
    tank.shot()
    tank.charge(Patron.BLUE)
    tank.shot()
    tank.shot()
    tank.charge(Patron.GREEN)
    tank.charge(Patron.BLUE)
    tank.shot()
    tank.charge(Patron.RED)
    tank.shot()
    tank.shot()
}

enum class Patron(val power: Int) {
    BLUE(5),
    GREEN(10),
    RED(20),
}

class Tank {
    private var charged: Patron? = null

    fun charge(patron: Patron) {
        if (charged == null) {
            charged = patron
        } else {
            println("Танк уже заряжен, перезарядить невозможно.")
        }
    }

    fun shot() {
        if (charged != null) {
            println("Произведен выстрел патроном ${charged!!.name}, урон составил ${charged!!.power}")
            charged = null
        } else {
            println("Танк не заряжен, урон 0.")
        }
    }
}