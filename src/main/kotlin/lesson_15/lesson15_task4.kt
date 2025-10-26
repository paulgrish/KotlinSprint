package lesson_15

/**
 * Задача 4 к Уроку 15
 *
 * На сайте музыкального магазина есть товары двух категорий: инструменты и комплектующие к ним. Все товары имеют
 * название и количество единиц на складе.
 * Для инструментов есть возможность поиска соответствующих комплектующих.
 *
 * Опиши классы для категорий товаров. Создай общий класс для хранения общих свойств всех товаров. Имитируй процесс
 * поиска текстовым сообщением «Выполняется поиск». Для выноса логики поиска используй интерфейс.
 */
fun main() {

}

abstract class Good(
    val name: String,
    val cost: Float,
) : Searchable {
    open fun printInfo() {
        println("%s: %.2f rub".format(name, cost))
    }
}

class Instrument(
    name: String,
    cost: Float,
) : Good(name, cost) {
    val id = nextId()

    override fun match(name_: String): Boolean {
        return name == name_
    }

    override fun match(instrumentId_: Int): Boolean {
        return false
    }

    companion object {
        private var idCounter = 0
        private fun nextId() = ++idCounter
    }
}

class Part(
    name: String,
    cost: Float,
    val instrumentId: Int,
) : Good(name, cost) {
    override fun match(name_: String): Boolean {
        return false
    }

    override fun match(instrumentId_: Int): Boolean {
        return instrumentId == instrumentId_
    }

    override fun printInfo() {
        print("\t")
        super.printInfo()
    }
}

interface Searchable {
    fun match(name_: String): Boolean
    fun match(instrumentId_: Int): Boolean
}