package lesson_1

//TIP Задача 5* к Уроку 1.
//
// Объяви переменную с количеством секунд, которые Гагарин провел в космосе.
// - Переведи в коде количество секунд в целые минуты и целые часы, сохраняя остаток секунд и минут в новые переменные;
// - Выведи в консоль время, проведенное в космосе в формате [часы:минуты:секунды], например так: 01:30:09;
// - Значения часов, минут и секунд отображать двумя цифрами.

fun main() {

    val totalSecondsInSpace = 6480
    val hoursInSpace = totalSecondsInSpace / (60 * 60)
    val minutesInSpace = (totalSecondsInSpace / 60) % 60
    val secondsInSpace = totalSecondsInSpace % 60

    println(String.format("%02d:%02d:%02d", hoursInSpace, minutesInSpace, secondsInSpace))
}

