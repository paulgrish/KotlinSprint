package lesson_17

/**
 * Задача 4 к Уроку 17
 *
 * Каждый раз, когда посылка прибывает в промежуточный пункт обработки, в программе меняется её местоположение.
 * Опиши класс посылки с такими вводными:
 * - свойства класса хранят: поле с номером посылки и поле с текущим местоположением;
 * - поле класса хранит счетчик перемещений, обновляющийся при перезаписи местоположения.
 *
 * Сымитировать прибытие посылки в новый пункт обработки, протестировать изменение счетчика. При реализации
 * использовать сеттер.
 */
fun main() {
    val box = PostBox(222, "Сургут")
    box.printInfo()
    box.place = "Екатеринбург"
    box.printInfo()
    box.place = "Москва"
    box.printInfo()
    box.place = "Санкт-Петербург"
    box.printInfo()
}

class PostBox(
    val id: Int,
    startPlace: String,
) {
    var place: String = startPlace
        set(value) {
            if (value != field) {
                field = value
                _moveCounter++
            }
        }

    private var _moveCounter: Int = 0
    val moveCounter: Int
        get() = _moveCounter

    fun printInfo() {
        println("Box ID: $id, place: $place, moves: $moveCounter")
    }
}