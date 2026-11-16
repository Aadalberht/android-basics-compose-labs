enum class Daypart { MORNING, AFTERNOON, EVENING }

data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int,
)

val Event.durationOfEvent: String
    get() = if (durationInMinutes < 60) "short" else "long"

fun main() {
    val events = mutableListOf(
        Event("Wake up", "Time to get up", Daypart.MORNING, 0),
        Event("Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event("Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event("Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event("Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event("Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45),
    )
    println("Total events: ${events.size}")
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("You have ${shortEvents.size} short events.")
    events.groupBy { it.daypart }.forEach { (daypart, dayEvents) ->
        println("$daypart: ${dayEvents.size} events")
    }
    println("Last event of the day: ${events.last().title}")
    println("Duration of first event of the day: ${events.first().durationOfEvent}")
}
