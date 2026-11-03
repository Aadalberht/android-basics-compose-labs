fun trafficInstruction(color: String): String = when (color) {
    "Red" -> "Stop"
    "Yellow" -> "Slow"
    "Green" -> "Go"
    else -> "Invalid traffic-light color"
}

fun primeDescription(value: Any): String = when (value) {
    2, 3, 5, 7 -> "$value is a prime number between 1 and 10."
    in 1..10 -> "$value is not a prime number between 1 and 10."
    is Int -> "$value is outside the range from 1 to 10."
    else -> "The value is not an integer."
}

fun main() {
    listOf("Red", "Yellow", "Green", "Black").forEach {
        println("$it: ${trafficInstruction(it)}")
    }
    println(primeDescription(3))
    println(primeDescription(4))
    println(primeDescription(12))
    println(primeDescription("three"))
}
