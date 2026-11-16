import java.util.Locale

data class Cookie(
    val name: String,
    val softBaked: Boolean,
    val hasFilling: Boolean,
    val price: Double,
)

fun main() {
    val cookies = listOf(
        Cookie("Chocolate Chip", false, false, 1.69),
        Cookie("Banana Walnut", true, false, 1.49),
        Cookie("Vanilla Creme", false, true, 1.59),
        Cookie("Chocolate Peanut Butter", false, true, 1.49),
        Cookie("Snickerdoodle", true, false, 1.39),
    )

    cookies.forEach { println("Menu item: ${it.name}") }
    println("Soft baked: ${cookies.filter { it.softBaked }.joinToString { it.name }}")
    val grouped = cookies.groupBy { it.softBaked }
    println("Soft count: ${grouped[true]?.size ?: 0}")
    val totalPrice = cookies.fold(0.0) { total, cookie -> total + cookie.price }
    println("Total price: $${String.format(Locale.US, "%.2f", totalPrice)}")
    println("Alphabetical: ${cookies.sortedBy { it.name }.joinToString { it.name }}")
}
