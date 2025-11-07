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

    println()
    instrument1.printInfo()
    instrument1.searchParts()
}

interface Searchable {
    fun searchParts()
}

abstract class Good(
    val name: String,
    val count: Int,
) {
    open fun printInfo() {
        println("${this::class.simpleName} \"$name\": на складе $count шт.")
    }
}

class Instrument(
    name: String,
    count: Int,
) : Good(name, count), Searchable  {
    val id = nextId()

    override fun searchParts() {
        println("Выполняется поиск...")
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

    override fun printInfo() {
        print("\t")
        super.printInfo()
    }
}
