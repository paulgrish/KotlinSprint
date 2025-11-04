package lesson_15

/**
 * Задача 5* к Уроку 15
 *
 * В логике мобильной игры есть грузовые и легковые автомобили с такими параметрами:
 * - грузовые машины могут перевозить одного пассажира и 2 тонны груза;
 * - легковые не перевозят груз, но могут вместить до 3 пассажиров.
 *
 * Создай интерфейсы, обеспечивающие передвижение машин, перевозку пассажиров и перевозку грузов.
 * - учитывай максимальное и текущее количество перевозимых людей или грузов;
 * - интерфейсы должны содержать методы загрузки и разгрузки пассажиров или грузов.
 *
 * Спроектируй классы и несколько объектов. Вызови их методы, «перевезя» таким образом 6 человек и 2 тонны груза.
 */
fun main() {

    Car().apply {
        loadPassengers(8)
        loadPassengers(0)
        loadCargo(1.0f)
        transfer()
        unload()
    }

    Car().apply {
        loadPassengers(2)
        loadPassengers(1)
        transfer()
        unload()
    }.apply {
        loadPassengers(1)
        transfer()
        unload()
    }

    Truck().apply {
        loadPassengers(2)
        loadCargo(2.8f)
        transfer()
        unload()
    }

    Truck().apply {
        loadPassengers(1)
        loadCargo(0.8f)
        transfer()
        unload()
    }.apply {
        loadCargo(0.95f)
        loadCargo(0.25f)
        transfer()
        unload()
    }.apply {
        loadPassengers(1)
        transfer()
        unload()
    }
}

interface Dockable {
    fun loadPassengers(count: Int)
    fun loadCargo(amount: Float)
    fun unload()
}

interface Movable {
    fun onLine() {
        println("*** Транспорт ${this::class.simpleName} вышел на линию.")
    }
    fun transfer()
}

abstract class Transport : Dockable, Movable {
    init {
        onLine()
    }
}

class Car : Transport() {
    var passengers = 0

    override fun loadPassengers(count: Int) {
        if (count > 0 && count <= passengers + CAR_MAX_PASSENGERS) {
            passengers += count
            println("Принял $count пассажиров")
        } else {
            println("Не могу принять $count пассажиров")
        }
    }

    override fun loadCargo(amount: Float) {
        println("Не могу принимать груз")
    }

    override fun unload() {
        println("Доставил $passengers пассажиров")
        passengers = 0
    }

    override fun transfer() {
        if (passengers > 0) {
            println("Перевожу $passengers пассажиров")
        } else {
            println("Некого перевозить")
        }
    }
}

class Truck : Transport() {
    var passengers = 0
    var cargo = 0.0f

    override fun loadPassengers(count: Int) {
        if (count > 0 && count <= passengers + TRUCK_MAX_PASSENGERS) {
            passengers += count
            println("Принял $count пассажиров")
        } else {
            println("Не могу принять $count пассажиров")
        }
    }

    override fun loadCargo(amount: Float) {
        if (amount > 0 && amount <= cargo + TRUCK_MAX_CARGO) {
            cargo += amount
            println("Принял $amount тонн груза")
        } else {
            println("Не могу принять $amount тонн груза")
        }
    }

    override fun unload() {
        println("Доставил $passengers пассажиров и $cargo тонн груза")
        passengers = 0
        cargo = 0.0f
    }

    override fun transfer() {
        if (passengers > 0 || cargo > 0.0f) {
            println("Перевожу $passengers пассажиров и $cargo тонн груза")
        } else {
            println("Нечего перевозить.")
        }
    }
}

const val CAR_MAX_PASSENGERS = 3
const val TRUCK_MAX_PASSENGERS = 1
const val TRUCK_MAX_CARGO = 2.0