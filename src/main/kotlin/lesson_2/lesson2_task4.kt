package lesson_2


fun main() {

    val amountOfCrystal = 7
    val amountOfFerrum = 11
    val buffInPercent = 20

    val buffDecimalFraction = buffInPercent / 100.0

    val bonusesOfCrystal = (amountOfCrystal * buffDecimalFraction).toInt()
    val bonusesOfFerrum = (amountOfFerrum * buffDecimalFraction).toInt()

    println("Crystal bonuses: $bonusesOfCrystal")
    println("Ferrum bonuses:  $bonusesOfFerrum")

}