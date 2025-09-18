package lesson_5

/**
 * Задача 5* к Уроку 5
 *
 * Для алгоритма улучшенного приложения-лотереи нужно угадать три числа от 0 до 42. Пользователь вводит числа
 * через консоль.
 *
 * Требования к программе:
 * - Загаданные числа должны рандомно генерироваться при каждом запуске программы и храниться в списке.
 * - Поочередно введенные пользователем числа должны также храниться в списке.
 * - Для определения совпадений используй метод intersect() и сохрани размер полученной коллекции в отдельную переменную.
 *
 * В зависимости от количества угаданных чисел программа выводит результат:
 * - При трех совпадениях сообщается, что пользователь угадал все числа и выиграл джекпот.
 * - При двух совпадениях информируется о том, что пользователь угадал два числа и получает крупный приз.
 * - Если угадано одно число, пользователю выплачивается утешительный приз.
 * - Если нет совпадений, программа сообщает, что пользователь не угадал ни одного числа.
 * - В конце игры вне зависимости от результата программа выводит выигрышные числа.
 */
fun main() {

    val hiddenNumbers = (MIN_NUMBER..MAX_NUMBER).shuffled().take(COUNT_OF_NUMBERS).sorted()

    println("Введите $COUNT_OF_NUMBERS разных чисел от $MIN_NUMBER до $MAX_NUMBER включительно через пробел:")
    val userItems = readln().split(' ').filter { it.length != 0 }
    val userAllNumbers = userItems.mapNotNull { it.toIntOrNull() }
    val userNumbers = userAllNumbers.filter { it in MIN_NUMBER..MAX_NUMBER }.toSet().toList()

    if (userItems.size != COUNT_OF_NUMBERS || userAllNumbers.size != COUNT_OF_NUMBERS ||
        userNumbers.size != COUNT_OF_NUMBERS
    ) {
        println("Необходимо было ввести $COUNT_OF_NUMBERS разных чисел от $MIN_NUMBER до $MAX_NUMBER включительно")
    } else {
        val matches = hiddenNumbers.intersect(userNumbers).size

        val resultMessage = when (matches) {
            3 -> "Вы угадали все числа и выиграли джекпот!"
            2 -> "Вы угадали два числа и получаете крупный приз!"
            1 -> "Вы угадали одно число получаете утешительный приз."
            0 -> "Вы не угадали ни одного числа."
            else -> "Что-то пошло не так. Примите участие в следующем тираже нашей лотереи!"
        }

        println(resultMessage)
        println("Выигрышные числа: ${hiddenNumbers.joinToString(" ")}")
    }
}

const val MIN_NUMBER = 0
const val MAX_NUMBER = 42
const val COUNT_OF_NUMBERS = 3
