package lesson_10.task_4

/**
 * Задача 4 к Уроку 10
 *
 * Усовершенствуй игру, где пользователь и компьютер по очереди бросают кости. Побеждает выбросивший наибольшее число.
 * Теперь дай возможность пользователю играть до тех пор пока ему не надоест. В конце программа должна вывести сколько
 * партий он выиграл.
 * - после первого раунда программа задает вопрос: “Хотите бросить кости еще раз? Введите Да или Нет”;
 * - программа в зависимости от ответа запускает новый раунд или заканчивает игру с выводом количества выигрышных
 * партий человека;
 * - в программе должно быть минимум 2 метода (для проведения раунда и для генерации значений брошенных кубиков);
 * - основная логика программы должна находиться в main(), а 2 другие функции будут вспомогательными.
 */
fun main() {

    println("Игра в кости.")

    var roundCount = 0
    var userWins = 0

    do {
        if (diceRound(++roundCount)) {
            userWins++
        }
    } while (needProceedGame())

    println("Человек выиграл раундов: $userWins из $roundCount.")

}

const val MAX_DICE_10_4_NUMBER = 6

/**
 * Обработка запроса пользователю о продолжении игры.
 * Возвращает true, если игру надо продолжить, иначе false.
 */
fun needProceedGame(): Boolean {

    while (true) {
        print("Хотите бросить кости еще раз? Введите Да или Нет: ")
        val userAnswer = readln().lowercase()

        when (userAnswer) {
            "да" -> return true
            "нет" -> return false
            else -> println("Вводите только Да или Нет!")
        }
    }
}

/**
 * Реализует один раунд игры в кости между человеком и компьютером.
 * Возвращает true, если победил человек, иначе false (ничья или человек проиграл).
 */
fun diceRound(number: Int): Boolean {

    println("\nРаунд $number.")
    val userNumber = diceHit()
    println("Человек бросил кость, результат: $userNumber")
    val computerNumber = diceHit()
    println("Компьютер бросил кость, результат: $computerNumber")

    val result = when {
        userNumber > computerNumber -> "Победило человечество" to true
        userNumber < computerNumber -> "Победила машина" to false
        else -> "Победила дружба" to false
    }
    println(result.first)

    return result.second
}

/**
 * Генерирует число, выпавшее на игральной кости.
 */
fun diceHit() = (1..MAX_DICE_10_4_NUMBER).random()