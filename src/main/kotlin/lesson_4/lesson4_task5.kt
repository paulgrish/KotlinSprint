package lesson_4

/**
 * Задача 5* к Уроку 4
 *
 * Научно-исследовательский корабль может приступить к долгосрочному плаванию при выполнении следующих условий:
 * - корабль не имеет повреждений;
 * - число экипажа составляет от 55 (включительно) до 70 человек (включительно);
 * - на борту есть более 50 ящиков провизии (не включительно);
 * - погода благоприятна или неблагоприятна.
 *
 * Альтернативно, корабль может отплыть даже при наличии незначительных повреждений, при условии что:
 * - на борту рекомендованный состав экипажа 70 человек;
 * - погода благоприятная;
 * - на борту есть 50 и более ящиков провизии.
 *
 * В качестве входных данных используй информацию, введенную через консоль:
 * - наличие повреждений корпуса (Boolean переменная);
 * - текущий состав экипажа;
 * - количество ящиков с провизией на борту;
 * - благоприятность метеоусловий (Boolean переменная).
 *
 * Напиши программу, которая будет определять, может ли корабль отправиться в плавание. Программа должна анализировать
 * эти данные и выводить результат в консоль. Для анализа должно использоваться единое составное условие, состоящие
 * только из логических операторов.
 */
fun main() {

    var shipIsDamaged: Boolean
    var crewSize: Int
    var ratioAmount: Int
    var weatherIsGood: Boolean

    println("Введите исходные данные о судне:")
    println("- наличие повреждений корпуса (true / false): ")
    shipIsDamaged = readln().toBoolean()
    println("- текущий состав экипажа (количество человек): ")
    crewSize = readln().toInt()
    println("- наличие провизии на борту (количество ящиков): ")
    ratioAmount = readln().toInt()
    println("- благоприятность метеоусловий (true / false): ")
    weatherIsGood = readln().toBoolean()

    val shipCanDeparture = shipIsDamaged == COND_DAMAGED && crewSize >= COND_MIN_CREW &&
            crewSize <= COND_MAX_CREW && ratioAmount > COND_MIN_RATIO_MORE ||
            shipIsDamaged == ALT_COND_DAMAGED && crewSize == ALT_COND_CREW &&
            ratioAmount >= ALT_COND_MIN_RATIO && weatherIsGood == ALT_COND_GOOD_WEATHER

    println("Этот корабль может отправиться в плавание: $shipCanDeparture")

}

const val COND_DAMAGED = false
const val COND_MIN_CREW = 55
const val COND_MAX_CREW = 70
const val COND_MIN_RATIO_MORE = 50

const val ALT_COND_DAMAGED = true
const val ALT_COND_CREW = 70
const val ALT_COND_MIN_RATIO = 50
const val ALT_COND_GOOD_WEATHER = true

