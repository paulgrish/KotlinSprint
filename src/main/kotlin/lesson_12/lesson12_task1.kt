package lesson_12

/**
 * Задача 1 к Уроку 12
 *
 * Программа отслеживает погоду по дням. Создай класс для хранения данных о температуре и осадках для одного дня.
 *
 * Объекты класса будут хранить:
 * - дневная температура;
 * - ночная температура;
 * - наличие осадков в течение суток.
 *
 * Создай два объекта, присвой им произвольные данные и выведи в консоль одним методом созданного класса.
 * - в классе создай переменные и проинициализируй их какими-нибудь значениями;
 * - затем в созданных объектах подставь другие значения этим переменным.
 *
 * В этой задаче используй пустой конструктор.
 */
fun main() {

    val day1 = DailyWeather()

    day1.dayCelsiusTemperature = 22f
    day1.nightCelsiusTemperature = 17f

    val day2 = DailyWeather()

    day2.dayCelsiusTemperature = -1.5f
    day2.nightCelsiusTemperature = -5.2f
    day2.dailyPrecipitation = true

    day1.printInfo()
    day2.printInfo()

}

class DailyWeather {

    var dayCelsiusTemperature: Float = +4.0f
    var nightCelsiusTemperature: Float = -1.0f
    var dailyPrecipitation: Boolean = false

    fun printInfo() {
        println("Температура днем %+.1f°C, ночью %+.1f°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
            if (dailyPrecipitation) "осадки" else "без осадков"
        )
    }
}