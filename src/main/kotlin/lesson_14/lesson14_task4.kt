package lesson_14

/**
 * Задача 4 к Уроку 14
 *
 * В компьютерной игре существуют планеты. У некоторых из них есть спутники.
 * Планеты и спутники могут иметь атмосферу и могут быть пригодными для высадки.
 *
 * Создай родительский класс, описывающий небесные тела, и подклассы, описывающие планеты и спутники.
 * - планета должна хранить список спутников.
 *
 * Создай планету с двумя спутниками и выведи в консоль название планеты и названия всех ее спутников.
 */
fun main() {

    val planet1 = Planet("Mars", isVisitable = true, satellites = listOf(
        Satellite("Deimos", isVisitable = false),
        Satellite("Fobos"),
    ))
    planet1.printBriefInfo()

    println()

    val planet2 = Planet("Mercury", hasAtmosphere = false, satellites = listOf())
    planet2.printBriefInfo()

}

abstract class SpaceObject(
    val name: String,
    val hasAtmosphere: Boolean = false,
    val isVisitable: Boolean = false,
) {
    open fun printBriefInfo() {
        println("${this::class.simpleName}: \"$name\"")
    }
}

class Planet(
    name: String,
    hasAtmosphere: Boolean = true,
    isVisitable: Boolean = false,
    val satellites: List<Satellite>
) : SpaceObject(name, hasAtmosphere, isVisitable) {

    override fun printBriefInfo() {
        super.printBriefInfo()
        if (satellites.size > 0) {
            println("Has satellites:")
            satellites.forEachIndexed { i, it ->
                print("${i + 1}. ")
                it.printBriefInfo()
            }
        } else {
            println("Has no satellites.")
        }
    }

}

class Satellite(
    name: String,
    hasAtmosphere: Boolean = false,
    isVisitable: Boolean = true,
) : SpaceObject(name, hasAtmosphere, isVisitable)