package lesson_12

/**
 * Задача 2 к Уроку 12
 *
 * Скопируй класс из предыдущей задачи и измени его название для избегания конфликтов.
 * - перепиши его, используя определение свойств в основном конструкторе;
 * - свойства не должны содержать значения по умолчанию (мы создаем каркас сущности для будущих объектов).
 *
 * Cоздай объект с произвольными данными и выведи в консоль методом созданного класса.
 */
fun main() {

    val day1 = DailyWeather2(5.2f, -1.7f, true)

    day1.printInfo()

}

class DailyWeather2(
    var dayCelsiusTemperature: Float,
    var nightCelsiusTemperature: Float,
    var dailyPrecipitation: Boolean,
) {
    fun printInfo() {
        println("Температура днем %+.1f°C, ночью %+.1f°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
                if (dailyPrecipitation) "осадки" else "без осадков"
        )
    }
}