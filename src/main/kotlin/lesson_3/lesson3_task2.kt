package org.example.lesson_3

/**
 * Задача 2 к Уроку 3
 *
 * Девушка по имени Андреева Татьяна Сергеевна в 22 года вышла замуж за Сидорова, и поменяла фамилию. О ней есть
 * запись в одном из государственных приложений. Приложение отслеживает изменения персональных данных граждан.
 *
 * Выведи в консоль данные на момент когда ей было 20 и на момент когда ей было 22 в формате [ФИО, возраст].
 * Все части ФИО и возраст изначально хранятся в отдельных переменных.
 */
fun main() {

    var lastName = "Andreyeva"
    val firstName = "Tatyana"
    val middleName = "Sergeyevna"
    var age = 20

    println("$lastName $firstName $middleName, $age")

    lastName = "Sidorova"
    age = 22

    println("$lastName $firstName $middleName, $age")
}