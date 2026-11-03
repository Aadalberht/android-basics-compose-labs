class Person(
    val name: String,
    val age: Int,
    val hobby: String?,
    val referrer: Person?
) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        val hobbyText = hobby?.let { "Likes to $it. " } ?: ""
        val referrerText = referrer?.let {
            val theirHobby = it.hobby?.let { hobby -> ", who likes to $hobby" } ?: ""
            "Has a referrer named ${it.name}$theirHobby."
        } ?: "Doesn't have a referrer."
        println(hobbyText + referrerText)
        println()
    }
}

fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)
    amanda.showProfile()
    atiqah.showProfile()
}
