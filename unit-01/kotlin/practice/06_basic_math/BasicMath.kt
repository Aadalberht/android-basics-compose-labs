fun main() {
    val firstNumber = 10
    val secondNumber = 5
    val thirdNumber = 8
    val result = firstNumber + secondNumber
    println("$firstNumber + $secondNumber = $result")
    println("$firstNumber + $thirdNumber = ${add(firstNumber, thirdNumber)}")
    println("$firstNumber - $secondNumber = ${subtract(firstNumber, secondNumber)}")
    println("$firstNumber - $thirdNumber = ${subtract(firstNumber, thirdNumber)}")
}

fun add(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber + secondNumber
}

fun subtract(firstNumber: Int, secondNumber: Int): Int {
    return firstNumber - secondNumber
}
