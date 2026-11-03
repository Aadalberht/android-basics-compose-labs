val trick: () -> Unit = { println("No treats!") }
val treat: () -> Unit = { println("Have a treat!") }

fun trickOrTreat(isTrick: Boolean, extraTreat: ((Int) -> String)? = null): () -> Unit {
    if (!isTrick) {
        println(extraTreat?.invoke(5) ?: "No bonus treats")
    }
    return if (isTrick) trick else treat
}

fun main() {
    val coins: (Int) -> String = { quantity -> "$quantity quarters" }
    val trickFunction = trickOrTreat(true)
    val treatFunction = trickOrTreat(false, coins)

    trickFunction()
    treatFunction()
    repeat(3) { treatFunction() }
}
