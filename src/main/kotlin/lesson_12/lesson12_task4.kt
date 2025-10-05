package lesson_12

/**
 * Задача 4 к Уроку 12
 *
 * Измени программу таким образом, чтобы информация о погоде выводилась в консоль сразу при создании объекта.
 */
fun main() {

    val day1 = DailyWeather4(295, 289, true)

}

class DailyWeather4(
    dayKelvinTemperature: Int,
    nightKelvinTemperature: Int,
    _dailyPrecipitation: Boolean,
) {
    val dayCelsiusTemperature: Int = dayKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val nightCelsiusTemperature: Int = nightKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val dailyPrecipitation: Boolean = _dailyPrecipitation

    init {
        printInfo()
    }

    fun printInfo() {
        println("Температура днем %+d°C, ночью %+d°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
                if (dailyPrecipitation) "осадки" else "без осадков"
        )
    }
}

const val CELSIUS_ZERO_IN_KELVIN = 273