package lesson_2

const val MINUTES_PER_HOUR = 60

fun main() {

    val departureHour = 9
    val departureMinute = 39
    val tripDurationInMinutes = 457

    val departureTimeInMinutes = departureHour * MINUTES_PER_HOUR + departureMinute
    val arrivalTimeInMinutes = departureTimeInMinutes + tripDurationInMinutes

    val arrivalHour = arrivalTimeInMinutes / MINUTES_PER_HOUR
    val arrivalMinute = arrivalTimeInMinutes % MINUTES_PER_HOUR

    println("Train arrival time: %02d:%02d".format(arrivalHour, arrivalMinute))

}