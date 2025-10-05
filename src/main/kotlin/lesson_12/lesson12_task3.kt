package lesson_12

/**
 * Задача 3 к Уроку 12
 *
 * Скопируй класс из предыдущей задачи и измени его название для избегания конфликтов.
 * - в этой задаче используй первичный конструктор без выделения памяти под свойства;
 * - поля должны быть объявлены и проинициализированы в теле класса;
 * - все поля с температурой должны иметь тип Int;
 * - программа не должна иметь других функций, кроме метода вывода информации о погоде.
 * В конструктор передается температура в Кельвинах. При обращении к полям с температурой возвращаются данные в
 * Цельсиях.
 *
 * Cоздай объект с произвольными данными и выведи в консоль методом созданного класса.
 */
fun main() {

    val day1 = DailyWeather3(295, 289, true)

    day1.printInfo()

}

class DailyWeather3(
    dayKelvinTemperature: Int,
    nightKelvinTemperature: Int,
    _dailyPrecipitation: Boolean,
) {
    var dayCelsiusTemperature: Int = dayKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    var nightCelsiusTemperature: Int = nightKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    var dailyPrecipitation: Boolean = _dailyPrecipitation

    fun printInfo() {
        println("Температура днем %+d°C, ночью %+d°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
                if (dailyPrecipitation) "осадки" else "без осадков"
        )
    }
}

const val CELSIUS_ZERO_IN_KELVIN = 273