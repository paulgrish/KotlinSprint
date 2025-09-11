package lesson_1

//TIP Задача 5* к Уроку 1.
//
// Объяви переменную с количеством секунд, которые Гагарин провел в космосе.
// - Переведи в коде количество секунд в целые минуты и целые часы, сохраняя остаток секунд и минут в новые переменные;
// - Выведи в консоль время, проведенное в космосе в формате [часы:минуты:секунды], например так: 01:30:09;
// - Значения часов, минут и секунд отображать двумя цифрами.

const val secondsPerMinute = 60
const val minutesPerHour = 60

fun main() {

    val totalSecondsInSpace = 6480
    val hoursInSpace = totalSecondsInSpace / (secondsPerMinute * minutesPerHour)
    val minutesInSpace = (totalSecondsInSpace / secondsPerMinute) % minutesPerHour
    val secondsInSpace = totalSecondsInSpace % secondsPerMinute

    println("%02d:%02d:%02d".format(hoursInSpace, minutesInSpace, secondsInSpace))
}

