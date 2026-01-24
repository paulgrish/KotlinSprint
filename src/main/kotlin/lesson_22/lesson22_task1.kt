package lesson_22

/**
 * Задача 1 к Уроку 22
 *
 * Создай обычный класс RegularBook и data class DataBook, каждый из которых содержит два свойства: название и автор.
 * Создай по два экземпляра каждого класса с одинаковыми свойствами, а затем сравни их (экземпляры), используя оператор сравнения.
 * Выведи результат сравнения в консоль для каждой пары объектов. Объясни разницу в выводе, используя комментарий в коде.
 */
fun main() {
    val rb1 = RegularBook("The Hitchhiker’s Guide to the Galaxy", "Douglas Noel Adams")
    val rb2 = RegularBook("The Hitchhiker’s Guide to the Galaxy", "Douglas Noel Adams")
    val db1 = DataBook("The Hitchhiker’s Guide to the Galaxy", "Douglas Noel Adams")
    val db2 = DataBook("The Hitchhiker’s Guide to the Galaxy", "Douglas Noel Adams")

    /* При использовании == объекты сравниваются по хэшу с использованием метода hashCode()
     * Для объектов обычных классов создается уникальный хэш вне зависимости от состояния объекта (его данных).
     * Поэтому одинаковые по состоянию объекты не равны друг другу.
     */
    println("RegularBook and RegularBook: ${rb1 == rb2}")

    /* Для объектов дата-классов хэш создается на основе значений их свойств, т.е. отражает их состояние.
     * Поэтому одинаковые по значению объекты будут иметь одинаковый хэш, т.е. равны.
     * Кстати, интересная штука: в классе RegularBook предупреждения, что свойства не используются, а в
     * DataBook этих предупреждений нет, видимо, потому что свойства таки используются в hashCode(), хоть и неявно
     */
    println("DataBook and DataBook: ${db1 == db2}")

    /* В силу предыдущих двух замечаний, у них вообще разные хэши, т.е. объекты не равны. */
    println("RegularBook and DataBook: ${rb1 == db1}")
}

class RegularBook(val caption: String, val author: String)

data class DataBook(val caption: String, val author: String)