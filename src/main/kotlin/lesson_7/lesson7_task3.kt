package lesson_7

/**
 * Задача 3 к Уроку 7
 *
 * Создай программу, которая выводит все чётные числа от нуля до числа, введенного пользователем. Сначала нужно
 * вывести в консоль запрос на ввод числа. Полученное число сохранить в отдельную переменную. При реализации должна
 * использоваться прогрессия.
 */
fun main() {

    var endNumber: Int

    while (true) {
        print("Введите положительное число: ")
        endNumber = readln().toInt()
        if (endNumber > 0)
            break
        println("Число должно быть положительным (больше 0)!")
    }

    println("Четные числа от 0 до $endNumber")
    val numbersSet = 0 .. endNumber step 2
    for (i in numbersSet) {
        println(i)
    }

}