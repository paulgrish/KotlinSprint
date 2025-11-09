package lesson_17

/**
 * Задача 2 к Уроку 17
 *
 * Опиши класс для корабля в мобильной игре. Поля хранят имя, среднюю скорость и порт приписки.
 *
 * Имя корабля менять нельзя, при попытке перезаписать имя в консоль должно выводиться предупреждение.
 *
 * Создай экземпляр класса и протестируй работу.
 */
fun main() {
    val ship = Ship("Смелый", 25, "Мурманск")
    ship.printInfo()
    ship.homeport = "Владивосток"
    ship.printInfo()
    ship.speed = 32
    ship.printInfo()
    ship.name = "Отважный"
    ship.printInfo()
}

class Ship(
    name_: String,
    var speed: Int,
    var homeport: String,
) {
    var name: String = name_
        get() = field
        set(value) {
            println("Имя корабля менять нельзя!")
        }

    fun printInfo() {
        println("Корабль \"$name\": скорость $speed узлов, порт приписки $homeport")
    }
}