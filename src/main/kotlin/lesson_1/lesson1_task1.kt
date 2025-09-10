package lesson_1

//TIP Задача 1 к Уроку 1.
//
// Пишем логику экрана приложения для интернет-магазина. Представим, что у интернет-магазина было 75 заказов.
// Нужно продумать релевантные названия и корректно объявить 2 переменные, которые будут содержать:
// – количество заказов,
// – текст с благодарностью за покупку (текст на твое усмотрение).
//
// Задай “говорящие” наименования переменных (например, для сторон прямоугольника не a и b, а height и width).
// Названия переменных должны состоять из нескольких слов. Тип переменных указывать принудительно.

fun main() {

    val maxNumberOfOrders = 75
    var countOfCurrentOrders = 25
    val thanksMessage = "Благодарим Вас за покупку в нашем интернет-магазине! Будем рады видеть Вас снова!"

    // И чтобы не было варнингов из-за неиспользованных переменных
    println("Your order #$countOfCurrentOrders in max $maxNumberOfOrders orders is complete")
    countOfCurrentOrders--
    println("Your order #$countOfCurrentOrders in max $maxNumberOfOrders orders is complete")
    println(thanksMessage)
    // но почему-то не вижу в консоли русский текст, только квадратики(

    val widthOfDoorInCm = 80.0f
    val heightOfDoorInCm = 200.0f
    val materialForDoor = "wood"

    println("Have you $materialForDoor door with size $widthOfDoorInCm x $heightOfDoorInCm cm?")

}
