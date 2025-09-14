package lesson_4

/**
 * Задача 4 к Уроку 4
 *
 * Программа тренировок разбивает упражнения на две группы: упражнения для мышц рук/пресса и ног/спины. Она рекомендует
 * делать упражнения на каждую группу мышц через день. Пользователь начал занятия с рук и пресса. Напиши программу,
 * которая будет сообщать, какие упражнения нужно выполнить сегодня.
 *
 * Предположим, что сегодня 5 день тренировок. В первый день выполнялись упражнения для рук и пресса. Выведи сообщение
 * в виде нескольких красивых ровных строк.
 *
 * Вывод должен быть таким:
 * Упражнения для рук:    true
 * Упражнения для ног:    false
 * Упражнения для спины:  false
 * Упражнения для пресса: true
 *
 * - все сообщение должно печататься в одном println();
 * - при изменении значения переменной дня тренировки на 1 день вперед, вывод должен меняться.
 */
fun main() {

    val dayNumber = 5

    val dayKind = (dayNumber % 2) == 1

    println("$EXEC_PREFIX рук:    ${dayKind == DAY_KIND_FOR_HANDS}")
    println("$EXEC_PREFIX ног:    ${dayKind == DAY_KIND_FOR_LEGS}")
    println("$EXEC_PREFIX спины:  ${dayKind == DAY_KIND_FOR_NECK}")
    println("$EXEC_PREFIX пресса: ${dayKind == DAY_KIND_FOR_PRESS}")
}

const val DAY_KIND_FOR_HANDS = true
const val DAY_KIND_FOR_LEGS = false
const val DAY_KIND_FOR_NECK = false
const val DAY_KIND_FOR_PRESS = true
const val EXEC_PREFIX = "Упражнения для"