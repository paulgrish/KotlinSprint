package lesson_1

// Задача 5* к Уроку 1.
//
// Объяви переменную с количеством секунд, которые Гагарин провел в космосе.
// - Переведи в коде количество секунд в целые минуты и целые часы, сохраняя остаток секунд и минут в новые переменные;
// - Выведи в консоль время, проведенное в космосе в формате [часы:минуты:секунды], например так: 01:30:09;
// - Значения часов, минут и секунд отображать двумя цифрами.

const val SECONDS_PER_MINUTE = 60
const val MINUTES_PER_HOUR = 60

fun main() {

    val totalSecondsInSpace = 6480
    val hoursInSpace = totalSecondsInSpace / (SECONDS_PER_MINUTE * MINUTES_PER_HOUR)
    val minutesInSpace = (totalSecondsInSpace / SECONDS_PER_MINUTE) % MINUTES_PER_HOUR
    val secondsInSpace = totalSecondsInSpace % SECONDS_PER_MINUTE

    println("%02d:%02d:%02d".format(hoursInSpace, minutesInSpace, secondsInSpace))
}

