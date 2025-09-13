package lesson_3

/**
 * Задача 5* к Уроку 3
 *
 * Продолжаем работать над приложением “Шахматы”. Напиши программу для сервера, которая примет строку, отправленную
 * игроком (считаем эти данные уже известными и объявляем строку с данными: “D2-D4;0”.
 *
 * Необходимо будет сделать обратное. Распарсить строку – разбить ее на 3 составляющих: откуда, куда и номер хода,
 * присвоить соответствующим переменным и распечатать по отдельности.
 */
fun main() {

    val userMoveString = "D2-D4;0"

    val moveFrom = userMoveString.substring(0..1)
    val moveTo = userMoveString.substring(3..4)
    val moveNumber = userMoveString.substring(6 until userMoveString.length).toInt()

    println(moveFrom)
    println(moveTo)
    println(moveNumber)
}