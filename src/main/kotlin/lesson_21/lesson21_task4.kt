package lesson_21

import java.io.File

/**
 * Задача 4 к Уроку 21
 *
 * В итоговом проекте блока KotlinSprint мы разрабатываем телеграм-бота на Kotlin, который помогает пользователям
 * учить иностранные слова. Создай extension функцию для класса File из стандартной библиотеки, которая будет
 * записывать переданное ей слово в файл.
 * - дополнительные материалы про файлы есть в 1-2 этапах курсовой;
 * - функция-расширение должна записывать текст в нижнем регистре;
 * - функция-расширение должна записывать текст в начало файла.
 *
 * ** Инфо про файлы **
 * https://androidsprint.ru/courses/kotlinsprint/learn/1.1
 * https://androidsprint.ru/courses/kotlinsprint/learn/1.2
 */
fun main() {
    var file: File = File("src\\main\\kotlin\\lesson_21\\file.txt")
    println(file.setReadable(true))
    println(file.setWritable(true))
    println(file.exists())
    println(file.canRead())
    println(file.canWrite())
    if (!file.exists()) {
        file.createNewFile()
//        println(file.setReadable(true))
//        println(file.setWritable(true))
        println(file.exists())
        println(file.canRead())
        println(file.canWrite())
    }
    file.writeText("test\n")
}

fun File.writeTextAtStart(text: String) {
    val content: String = if (this.exists()) {
        readText()
    } else {
        this.createNewFile()
        ""
    }
    this.writeText(text.lowercase() + content)
}