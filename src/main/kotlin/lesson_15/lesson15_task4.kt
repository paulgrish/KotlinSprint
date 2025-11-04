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

    val instrument1 = Instrument("Гитара", 5)
    val instrument2 = Instrument("Пианино", 2)
    val instrument3 = Instrument("Там-там", 12)
    val store = listOf<Good>(
        instrument1,
        Part("Струны металлические (комплект)", 32, instrument1.id),
        Part("Струны нейлоновые (комплект)",52, instrument1.id),
        Part("Медиатор", 114, instrument1.id),
        instrument2,
        Part("Струна басовая (в асс.)", 67, instrument2.id),
        Part("Молоточек средний", 7, instrument2.id),
        Part("Демпфер", 79, instrument2.id),
        instrument3,
        Part("Винт", 41, instrument3.id),
        Part("Кожа", 3, instrument3.id),
        Instrument("Ксилофон", 1),
    )

    store.forEach {
        it.printInfo()
    }

    print("Введите название инструмента для поиска: ")
    val name = readln()
    println("Выполняется поиск...")
    val foundInstrument = store.find { it.match(name) }
    if (foundInstrument != null) {
        foundInstrument.printInfo()
        println("Выполняется поиск комплектующих...")
        store.filter { it.match((foundInstrument as Instrument).id) }
            .let {
                if (it.size > 0) {
                    it.forEach { it.printInfo() }
                } else {
                    println("Ничего не найдено.")
                }
            }
    } else {
        println("Ничего не найдено.")
    }
}

abstract class Good(
    val name: String,
    val count: Int,
) : Searchable {
    open fun printInfo() {
        println("${this::class.simpleName} \"$name\": на складе $count шт.")
    }
}

class Instrument(
    name: String,
    count: Int,
) : Good(name, count) {
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
    count: Int,
    val instrumentId: Int,
) : Good(name, count) {
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