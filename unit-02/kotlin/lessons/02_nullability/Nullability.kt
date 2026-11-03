fun actorSummary(name: String?): String {
    val length = name?.length ?: 0
    return if (name == null) {
        "No favorite actor selected. Name length: $length"
    } else {
        "Favorite actor: $name. Name length: $length"
    }
}

fun main() {
    var favoriteActor: String? = "Sandra Oh"
    println(actorSummary(favoriteActor))

    favoriteActor = null
    println(actorSummary(favoriteActor))
    println("Uppercase value: ${favoriteActor?.uppercase() ?: "UNKNOWN"}")
}
