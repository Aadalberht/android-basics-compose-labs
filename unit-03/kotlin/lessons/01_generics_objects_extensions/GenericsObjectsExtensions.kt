enum class Difficulty { EASY, MEDIUM, HARD }

data class QuizQuestion<T>(
    val questionText: String,
    val answer: T,
    val difficulty: Difficulty,
)

class Quiz {
    val question1 = QuizQuestion("Quoth the raven ___", "nevermore", Difficulty.MEDIUM)
    val question2 = QuizQuestion("The sky is green. True or false", false, Difficulty.EASY)
    val question3 = QuizQuestion("How many days are between full moons?", 28, Difficulty.HARD)

    companion object StudentProgress {
        var answered = 3
        var total = 10
    }
}

val Quiz.StudentProgress.progressText: String
    get() = "$answered of $total answered"

fun Quiz.StudentProgress.printProgressBar() {
    repeat(answered) { print("#") }
    repeat(total - answered) { print("-") }
    println()
    println(progressText)
}

fun main() {
    Quiz.printProgressBar()
    val quiz = Quiz()
    quiz.apply {
        println(question1)
        println(question2)
        println(question3)
    }
}
