package lesson_17

/**
 * Задача 3 к Уроку 17
 *
 * В приложении для хранения облачных файлов есть папки и файлы.
 *
 * Создай класс папки, который имеет имя, количество файлов и флаг “секретно”. Если флаг имеет значение true,
 * то при попытке прочитать имя, возвращать строку “скрытая папка” и количество файлов – 0. В ином случае возвращать
 * ее название и реальное количество файлов. Для реализации должны использоваться геттеры.
 *
 * Создай экземпляр “скрытой” папки. Протестируй попытку чтения ее данных.
 */
fun main() {
    val folder = Folder("Photos", 3456, true)
    folder.printInfo()
    println("Раскрываем папку...")
    folder.secret = false
    folder.printInfo()
}

class Folder(
    name_: String,
    filesCount_: Int,
    var secret: Boolean = false,
) {
    val name: String = name_
        get() = if (secret) "скрытая папка" else field

    val filesCount: Int = filesCount_
        get() = if (secret) 0 else field

    fun printInfo() {
        println("$name: $filesCount files")
    }
}