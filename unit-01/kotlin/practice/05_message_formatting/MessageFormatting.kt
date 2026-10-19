fun main() {
    val baseSalary = 5000
    val bonusAmount = 1000
    // Prediction: 5000 + 1000, since the plus sign is literal text here.
    val totalSalary = "$baseSalary + $bonusAmount"
    println("Congratulations for your bonus! You will receive a total of $totalSalary (additional bonus).")
    println("Numeric sum: ${baseSalary + bonusAmount}")
}
