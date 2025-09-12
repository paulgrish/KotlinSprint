package lesson_2

const val NUM_OF_STUDENTS = 4

fun main() {

    val grade1 = 3f
    val grade2 = 4f
    val grade3 = 3f
    val grade4 = 5f

    val meanGrade = (grade1 + grade2 + grade3 + grade4) / NUM_OF_STUDENTS

    println("%.2f".format(meanGrade))

}