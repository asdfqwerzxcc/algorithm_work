import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    while (true) {
        val (a, b) = readLine().split(" ").map { it.toInt() }
        if (a == 0) break

        println(
                disting(a, b)
        )
    }
}

fun disting(a: Int, b: Int): String {
    return if (a > b) {
        if (a % b == 0) "multiple"
        else "neither"
    } else {
        if (b % a == 0) "factor"
        else "neither"
    }
}