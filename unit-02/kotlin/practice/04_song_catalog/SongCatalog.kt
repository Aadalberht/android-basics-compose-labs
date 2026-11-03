class Song(
    val title: String,
    val artist: String,
    val yearPublished: Int,
    val playCount: Int
) {
    val isPopular: Boolean
        get() = playCount >= 1_000

    fun description(): String = "$title, performed by $artist, was released in $yearPublished."
}

fun main() {
    val song = Song("We Don't Talk About Bruno", "Encanto Cast", 2022, 1_000_000)
    println(song.description())
    println("Popular: ${song.isPopular}")
}
