import java.util.Scanner

fun main() = with(Scanner(System.`in`)){
    val a = nextInt()
    val score=IntArray(a){nextInt()}
    score.sort()

    score.forEach{ println("${it}") }
}