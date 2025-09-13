package lesson_2

import kotlin.math.pow

fun main() {

    val depositInRub = 70_000f
    val rateInPercent = 16.7
    val periodInYears = 20

    val finishDepositInRub = depositInRub * (1 + rateInPercent / 100).pow(periodInYears.toDouble())

    println("Total deposit value at end of period: %.3f RUB".format(finishDepositInRub))

}