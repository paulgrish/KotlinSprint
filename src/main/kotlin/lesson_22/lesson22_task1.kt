package org.example.lesson_22

/**
 * Задача 1 к Уроку 22
 *
 * Создай обычный класс RegularBook и data class DataBook, каждый из которых содержит два свойства: название и автор.
 * Создай по два экземпляра каждого класса с одинаковыми свойствами, а затем сравни их (экземпляры), используя оператор сравнения.
 * Выведи результат сравнения в консоль для каждой пары объектов. Объясни разницу в выводе, используя комментарий в коде.
 */
fun main() {

}

class RegularBook(val caption: String, val author: String)

data class DataBook(val caption: String, val author: String)