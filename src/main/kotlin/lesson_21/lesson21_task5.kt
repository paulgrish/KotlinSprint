package lesson_21

/**
 * Задача 5* к Уроку 21
 *
 * Игра имеет систему прокачки персонажей по различным навыкам. Опыт в каждом навыке хранится в виде пары
 * ключ-значение, где ключ — это название навыка (String), а значение — количество очков опыта (Int).
 *
 * Создай extension функцию для интерфейса Map<String, Int> с названием maxCategory, которая будет возвращать
 * название навыка, в котором у игрока наибольшее количество очков опыта. Если два или более навыка имеют
 * одинаковое максимальное значение, функция должна возвращать первый найденный из них.
 */
fun main() {
    val expMap = mapOf(
        "health" to 55,
        "strong" to 18,
        "speed" to 78,
        "jumpiness" to 23,
        "intelligence" to 78,
        "force" to 34,
    )
    println(expMap.maxCategory())
}

fun Map<String, Int>.maxCategory(): String {
    return this.maxBy { selector: Map.Entry<String, Int> -> Int
        selector.value
    }.key
}