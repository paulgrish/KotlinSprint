package lesson_2

fun main() {

    val countOfEmployees = 50
    val salaryOfEmployee = 30_000

    val countOfInterns = 30
    val salaryOfIntern = 20_000

    val totalSalaryOfEmployees = countOfEmployees * salaryOfEmployee
    val totalSalary = totalSalaryOfEmployees + countOfInterns * salaryOfIntern
    val meanSalary = totalSalary / (countOfEmployees + countOfInterns)

    println("Total salary of employees: $totalSalaryOfEmployees")
    println("Total salary of all staff: $totalSalary")
    println("Mean salary of all staff:  $meanSalary")

}