package lesson_19

/**
 * Задача 1 к Уроку 19
 *
 * В симуляторе аквариума есть 4 вида рыб.
 * Гуппи (guppy),
 * скалярия (angelfish),
 * золотая рыбка (Goldfish),
 * петушок (Siamese fighting fish).
 * Напиши enum класс, перечисляющий этих рыб. Сообщи пользователю, каких рыб он может добавить в свой аквариум,
 * распечатав список в консоль.
 */
fun main() {
    println("Вы можете добавить в аквариум рыбок следующих типов:")
    println(FishKinds.entries.joinToString())
    println("Полные названия этих рыбок:")
    println(FishKinds.entries.joinToString { it.fullName })
}

enum class FishKinds (val fullName: String) {
    GUPPY("guppy"),
    ANGELFISH("angelfish"),
    GOLDFISH("goldfish"),
    SIAMESEFIGHTINGFISH("siamese fighting fish"),
}