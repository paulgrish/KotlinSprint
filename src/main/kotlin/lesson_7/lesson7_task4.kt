package lesson_7

/**
 * Задача 4 к Уроку 7
 *
 * Cоздай таймер, который сперва запрашивает у пользователя количество секунд, которые нужно засечь.
 *  – таймер должен показывать каждую секунду, сколько времени осталось до конца;
 *  – по истечении времени, вывести сообщение в консоль: “Время вышло”;
 *  – таймер должен быть написан, используя цикл for.
 */
fun main() {

    var timerPeriodInSeconds: Int

    while (true) {
        println("Задайте длительность работы таймера (в секундах):")
        timerPeriodInSeconds = readln().toInt()
        if (timerPeriodInSeconds > 0)
            break
        println("Длительность работы таймера должна быть положительным числом!")
    }

    println("Таймер запущен...")
    for (tick in timerPeriodInSeconds downTo 1) {
        println("Осталось секунд: $tick")
        Thread.sleep(1000)
    }

    println("Время вышло")

}