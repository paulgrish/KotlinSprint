package lesson_1

//TIP Задача 3 к Уроку 1
//
// В любом учебнике есть задачи про космос. Объяви переменные и выведи данные о полете в космос первого человека.
// – Запиши в новую переменную year год полета Юрия Гагарина в космос;
// – Объяви и проинициализируй переменные hour и minute – час и минуту взлета соответственно;
// – Выведи год, час и минуту взлета по одной переменной на каждую строку;
// – Затем измени значения переменных hour и minute, чтобы они теперь имели значение часа и минуты посадки;
// – Выведи время посадки в одной строке в формате [часы:минуты]. Пример: 10:55.
//
// Определи, где в программе переменные должны задаваться через val, а где через var.
//
// Данные для задачи:
// Год полета – 1961
// Взлет – 09:07
// Посадка – 10:55
//
// Подсказка для вывода: какой метод печати в консоль не делает перенос в конце строки?

fun main() {

    //TIP Sorry, my english is so-so...

    val yearOfFirstHumanUpToSpace = 1961
    var hourOfFirstHumanUpToSpace = 9
    var minuteOfFirstHumanUpToSpace = 7

    println(yearOfFirstHumanUpToSpace)
    println(hourOfFirstHumanUpToSpace)
    println(minuteOfFirstHumanUpToSpace)

    hourOfFirstHumanUpToSpace = 10
    minuteOfFirstHumanUpToSpace = 55

    // функцию print() не использовал, т.к. сразу собрал строку в требуемом формате
    println("$hourOfFirstHumanUpToSpace:$minuteOfFirstHumanUpToSpace")

    // Спасибо C, приятно узнать, что корректно (в привычном виде для любого значения времени)
    // собрать строку можно как в ...printf() )
    println(String.format("%02d:%02d", hourOfFirstHumanUpToSpace, minuteOfFirstHumanUpToSpace))
}
