package org.example.lesson_3

/**
 * Задача 3 к Уроку 3
 *
 * Пишем программу, которая будет помогать учить таблицу умножения. В отдельную переменную будет записываться число
 * (объявить и проинициализировать), а выводиться будет таблица умножения для этого числа. Таблица должна корректно
 * печататься, если в исходную переменную подставлять разные числа.
 *
 * Пример вывода:
 * 6 x 1 = 6
 * 6 x 2 = 12
 * …
 * 6 x 9 = 54
 *
 *  – Вместо числа 6 использовать данные из объявленной переменной;
 *  – Вычислять значения прямо в строке;
 *  – Вывод всей таблицы нужно сделать в одной функции println(), которая вызывается один раз.
 */
fun main() {

    val multipliable = 6

    println("""
         |$multipliable x 1 = ${multipliable * 1}
         |$multipliable x 2 = ${multipliable * 2}
         |$multipliable x 3 = ${multipliable * 3}
         |$multipliable x 4 = ${multipliable * 4}
         |$multipliable x 5 = ${multipliable * 5}
         |$multipliable x 6 = ${multipliable * 6}
         |$multipliable x 7 = ${multipliable * 7}
         |$multipliable x 8 = ${multipliable * 8}
         |$multipliable x 9 = ${multipliable * 9}
            """.trimMargin())
}