package lesson_12

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
            (DAY_TEMPERATURE_LOW .. DAY_TEMPERATURE_HI).random(),
            (NIGHT_TEMPERATURE_LOW .. NIGHT_TEMPERATURE_HI).random(),
            (1 .. DAILY_PRECIPITATION_MAX).random() <= DAILY_PRECIPITATION_PERCENT
        )
    }

//    monthWeatherData.forEach { it.printInfo() }


}

class DailyWeatherData(
    dayKelvinTemperature: Int,
    nightKelvinTemperature: Int,
    _dailyPrecipitation: Boolean,
) {
    val dayCelsiusTemperature: Int = dayKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val nightCelsiusTemperature: Int = nightKelvinTemperature - CELSIUS_ZERO_IN_KELVIN
    val dailyPrecipitation: Boolean = _dailyPrecipitation

    fun printInfo() {
        println("Температура днем %+d°C, ночью %+d°C, ".format(dayCelsiusTemperature, nightCelsiusTemperature) +
                if (dailyPrecipitation) "осадки" else "без осадков"
        )
    }
}

const val CELSIUS_ZERO_IN_KELVIN = 273

const val DAYS_IN_MONTH = 30

const val DAY_TEMPERATURE_BASE = 295
const val DAY_TEMPERATURE_VARIATION = 5
const val NIGHT_TEMPERATURE_DIFFERENCE = 9
const val NIGHT_TEMPERATURE_BASE = DAY_TEMPERATURE_BASE - NIGHT_TEMPERATURE_DIFFERENCE
const val NIGHT_TEMPERATURE_VARIATION = 7
const val DAILY_PRECIPITATION_MAX = 100

const val DAY_TEMPERATURE_HI = DAY_TEMPERATURE_BASE + DAY_TEMPERATURE_VARIATION
const val DAY_TEMPERATURE_LOW = DAY_TEMPERATURE_BASE - DAY_TEMPERATURE_VARIATION
const val NIGHT_TEMPERATURE_HI = NIGHT_TEMPERATURE_BASE + NIGHT_TEMPERATURE_VARIATION
const val NIGHT_TEMPERATURE_LOW = NIGHT_TEMPERATURE_BASE - NIGHT_TEMPERATURE_VARIATION
const val DAILY_PRECIPITATION_PERCENT = 68
