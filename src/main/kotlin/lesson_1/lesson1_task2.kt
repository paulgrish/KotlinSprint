package lesson_1

//TIP Задача 2 к Уроку 1.
//
// Скопируй решение из задачи 1 в новый файл с задачей 2. Теперь необходимо дописать реализацию программы для новых целей.
// Имитируем логи с сервера.
// – Для начала выведи в консоль значения всех объявленных ранее переменных;
// – Далее нужно сделать так, чтобы программа хранила количество работников данного интернет-магазина (2000).
// Подбери подходящее наименование переменной, присвой ей значение и распечатай;
// – Далее представим, что один работник уволился. Закомментируй предыдущий код с распечаткой количества работников,
// присвой новое значение количества работников этой переменной и распечатай в консоль.
//
// Оценивается не только правильная последовательность действий, но и грамотная организация кода (порядок объявления, отступы и так далее).

fun main() {

    val maxNumberOfOrders = 75
    var countOfCurrentOrders = 25
    val thanksMessage = "Благодарим Вас за покупку в нашем интернет-магазине! Будем рады видеть Вас снова!"

    // Вывод переменных уже был, поэтому оставил его как есть
    println("Your order #$countOfCurrentOrders in max $maxNumberOfOrders orders is complete")
    countOfCurrentOrders--
    println("Your order #$countOfCurrentOrders in max $maxNumberOfOrders orders is complete")
    println(thanksMessage)

    val widthOfDoorInCm = 80.0f
    val heightOfDoorInCm = 200.0f
    val materialForDoor = "wood"

    println("Have you $materialForDoor door with size $widthOfDoorInCm x $heightOfDoorInCm cm?")

    var countOfMarketplaceStuff = 2000

//    println("Current stuff: $countOfMarketplaceStuff")

    countOfMarketplaceStuff = 1999 // По заданию требуется присвоить значение, но можно и уволить одного, т.е. --

    println("Current stuff: $countOfMarketplaceStuff")
}
