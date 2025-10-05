package lesson_12

import kotlin.random.Random

/**
 * Задача 5* к Уроку 12
 *
 * Продолжи усовершенствовать программу, теперь она должна рассчитывать средние значения температур и считать
 * количество дней с осадками за месяц.
 *
 * Представь, что данные ты получаешь от датчиков. Сымитируй их поведение с помощью random.
 * - в функции main() создай список и добавь в него с помощью цикла 30 объектов класса, передав в конструкторы
 * случайные значения;
 * - извлеки из списка дневные и ночные температуры, используя функцию map, а также посчитай количество дней с
 * осадками;
 * - вычисли средние значения дневных и ночных температур с помощью специальной extension-функции из стандартной
 * библиотеки;
 * - посчитай количество дней с осадками.
 *
 * Выведи результаты в консоль.
 */
fun main() {

    val monthWeatherData = List(DAYS_IN_MONTH) {
        DailyWeatherData(
            dayKelvinTemperature = Random.nextInt(DAY_TEMPERATURE_LOW, DAY_TEMPERATURE_HI + 1),
            nightKelvinTemperature = Random.nextInt(NIGHT_TEMPERATURE_LOW, NIGHT_TEMPERATURE_HI + 1),
            _hasDayPrecipitation = Random.nextInt(0, DAILY_PRECIPITATION_MAX) <= DAILY_PRECIPITATION_PERCENT
        )
    }

    val dayTemperatures = monthWeatherData.map { it.dayCelsiusTemperature }
    val nightTemperatures = monthWeatherData.map { it.nightCelsiusTemperature }
    val dailyPrecipitations = monthWeatherData.map { it.hasDayPrecipitation }

    val dayTemperatureAverage = dayTemperatures.average()
    val nightTemperatureAverage = nightTemperatures.average()
    val precipitationDaysCount = dailyPrecipitations.filter { it }.size

    println("Средняя дневная температура за $DAYS_IN_MONTH дней: %+.1f°C".format(dayTemperatureAverage))
    println("Средняя ночная температура за $DAYS_IN_MONTH дней: %+.1f°C".format(nightTemperatureAverage))
    println("Количество дней с осадками за $DAYS_IN_MONTH дней: $precipitationDaysCount")

}

class DailyWeatherData(
    dayKelvinTemperature: Int,
    nightKelvinTemperature: Int,
    _hasDayPrecipitation: Boolean,
) {
    val dayCelsiusTemperature: Int = dayKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val nightCelsiusTemperature: Int = nightKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val hasDayPrecipitation: Boolean = _hasDayPrecipitation

    fun printInfo() {
        println(
            "Температура днем %+d°C, ночью %+d°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
                    if (hasDayPrecipitation) "осадки" else "без осадков"
        )
    }
}

const val CELSIUS_ZERO_IN_KELVIN = 273

const val DAYS_IN_MONTH = 30

const val DAILY_PRECIPITATION_MAX = 100
const val DAILY_PRECIPITATION_PERCENT = 68

const val DAY_TEMPERATURE_HI = CELSIUS_ZERO_IN_KELVIN + 27
const val DAY_TEMPERATURE_LOW = CELSIUS_ZERO_IN_KELVIN + 18
const val NIGHT_TEMPERATURE_HI = CELSIUS_ZERO_IN_KELVIN + 20
const val NIGHT_TEMPERATURE_LOW = CELSIUS_ZERO_IN_KELVIN + 15
