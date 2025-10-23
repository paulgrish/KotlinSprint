package lesson_15

/**
 * Задача 2 к Уроку 15
 *
 * Необходимо разработать простую систему мониторинга погодных условий, которая будет собирать данные о температуре и
 * количестве осадков.
 *
 * Создай абстрактный класс WeatherStationStats. Он будет служить родителем для классов-объектов погодных данных:
 * Temperature и PrecipitationAmount.
 * Реализуй логику имитации отправки сообщения на сервер в классе WeatherServer. Метод отправки сообщения должен
 * принимать объект типа WeatherStationStats и, в зависимости от типа переданного объекта, выводить соответствующие
 * данные.
 *
 * Создай по одному объекту для разных типов погодных данных и протестируй работу программы.
 */
fun main() {

    val server = WeatherServer()

    val data1 = Temperature(22.7f)
    val data2 = PrecipitationAmount(4)

    server.sendMessage(data1)
    server.sendMessage(data2)

}

class WeatherServer {
    fun sendMessage(msg: WeatherStationStats) {
        msg.printWeatherData()
    }
}

abstract class WeatherStationStats {
    abstract fun printWeatherData()
}

class Temperature(
    val temperature: Float
) : WeatherStationStats() {
    override fun printWeatherData() {
        println("Temperature = %.1f°C".format(temperature))
    }
}

class PrecipitationAmount(
    val precipitationInMm: Int
) : WeatherStationStats() {
    override fun printWeatherData() {
        println("Preciptation = $precipitationInMm mm")
    }
}
