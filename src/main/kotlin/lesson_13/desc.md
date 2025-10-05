❌ 13: Null Safety, NPE | Задачи

Kotlin внедрил концепцию null safety для избежания NullPointerException, одной из самых распространенных ошибок в Java.

Способы обработки nullable описаны здесь: https://gist.github.com/1dcca1d76c57b9268ac026b6391c3d09.git

Также null safety можно обеспечить используя оператор безопасного вызова совместно со scope functions.

Например, nullableString?.let {} или nullableString?.also {}.

Подробнее про scope functions будет в следующем превью.

Чтобы пользователи не оставляли истеричных отзывов в Google Play из-за постоянных вылетов, учимся обрабатывать null здесь:
https://youtu.be/hf4vrHucYNU
https://vk.com/video-85562117_456239034

Задавай вопросы в комментарии к PR и пиши в ЛС:
@ievetrovdev, Орг. вопросы: @androidsprint_support