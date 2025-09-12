package lesson_2

const val BUFF_DECIMAL_FRACTION = 0.2f

fun main() {

    val amountOfCrystal = 7
    val amountOfFerrum = 11

    val bonusesOfCrystal = (amountOfCrystal * BUFF_DECIMAL_FRACTION).toInt()
    val bonusesOfFerrum = (amountOfFerrum * BUFF_DECIMAL_FRACTION).toInt()

    println("Crystal bonuses: $bonusesOfCrystal")
    println("Ferrum bonuses:  $bonusesOfFerrum")

}