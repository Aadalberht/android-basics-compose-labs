fun main() {
    printGreeting()
    println(birthdayGreeting(age = 5))
    println(birthdayGreeting(age = 2, name = "Rex"))
    println(birthdayGreeting(age = 2))
}

fun printGreeting() {
    println("Happy Birthday!")
}

fun birthdayGreeting(name: String = "Rover", age: Int): String {
    val nameGreeting = "Happy Birthday, $name!"
    val ageGreeting = "You are now $age years old!"
    return "$nameGreeting\n$ageGreeting"
}
