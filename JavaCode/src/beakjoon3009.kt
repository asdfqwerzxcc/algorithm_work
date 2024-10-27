import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val x1 = nextInt()
    val y1 = nextInt()
    val x2 = nextInt()
    val y2 = nextInt()
    val x3 = nextInt()
    val y3 = nextInt()

    var x4 = 0
    var y4 = 0

    if (x1 == x2) {
        x4 = x3
    } else if (x1 == x3) {
        x4 = x2
    } else if (x2 == x3) {
        x4 = x1
    } else {
        println(-1)
    }

    if (y1 == y2) {
        y4 = y3
    } else if (y1 == y3) {
        y4 = y2
    } else if (y2 == y3) {
        y4 = y1
    } else {
        println(-1)
    }

    println("$x4 $y4")
}