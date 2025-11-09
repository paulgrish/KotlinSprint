package lesson_16

/**
 * Задача 4 к Уроку 16
 *
 * Создай класс, описывающий заказ в интернет-магазине. В заказе должны быть номер заказа и статус готовности.
 * Номер заказа должен быть недоступен для изменения.
 *
 * Создай метод, который меняет статус заказа. Поменять статус заказа можно только отправив заявку менеджеру.
 * Имитируй это действие отдельной публичной функцией. Она будет принимать новый статус и обращаться к внутреннему
 * методу класса для изменения статуса.
 */
fun main() {
    val order1 = Order(222)
    println("Статус готовности: ${order1.getReadyStatus()}")
    order1.changeReadyStatus(false)
    println("Статус готовности: ${order1.getReadyStatus()}")
    order1.changeReadyStatus(true)
    println("Статус готовности: ${order1.getReadyStatus()}")
    order1.changeReadyStatus(true)
    println("Статус готовности: ${order1.getReadyStatus()}")
}

class Order(
    val id: Int,
) {
    private var readyStatus = false

    private fun applyReadyStatus(newStatus: Boolean) {
        readyStatus = newStatus
    }

    fun getReadyStatus() = readyStatus

    fun changeReadyStatus(newStatus: Boolean) {
        if (changeReadyStatusRequest(id, readyStatus, newStatus)) {
            applyReadyStatus(newStatus)
            println("Статус заказа $id изменен на \"${if (readyStatus) "ГОТОВ" else "НЕ ГОТОВ"}\"")
        } else {
            println("В изменении статуса заказа $id отказано")
        }
    }
}

fun changeReadyStatusRequest(orderId: Int, currentStatus: Boolean, newStatus: Boolean): Boolean {
    println("Заявка на изменение статуса заказа $orderId отправлена менеджеру")
    return currentStatus != newStatus && (1..100).random() <= ACCEPT_CHANGE_STATUS_PERCENT
}

const val ACCEPT_CHANGE_STATUS_PERCENT = 82