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

    val day1 = DailyWeatherData(295, 289, true)

}

class DailyWeatherData(
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