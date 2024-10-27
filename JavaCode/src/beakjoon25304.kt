import java.util.Scanner

fun main() = with(Scanner(System.`in`)) {
    val total = nextInt()
    val num = nextInt()
    var result = 0

    for (i in 1..num) {
        var a = nextInt()
        var b = nextInt()

        result += a * b
    }

    if (total == result) {
        print("Yes")
    } else {
        print("No")
    }
}