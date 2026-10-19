fun main() {
    val count: Int = 2
    println("You have $count unread messages.")
    var cartTotal = 0
    cartTotal = 20
    println("Total: $cartTotal")
    cartTotal++
    println("Total after increment: $cartTotal")
    cartTotal--
    println("Total after decrement: $cartTotal")
    val unreadCount = 5
    val readCount = 100
    println("You have ${unreadCount + readCount} total messages in your inbox.")
    val nextMeeting = "Next meeting: "
    val date = "January 1"
    val reminder = nextMeeting + date + " at work"
    println(reminder)
    println("Say \"hello\" to Kotlin")
    val trip1: Double = 3.20
    val trip2: Double = 4.10
    val trip3: Double = 1.72
    println("Travel distance: ${trip1 + trip2 + trip3}")
    val notificationsEnabled: Boolean = true
    println("Notifications enabled: $notificationsEnabled")
    // Changing a var is allowed; a val can only be initialized once.
    var messages = 10
    messages--
    println("You have $messages unread messages.")
}
