import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val meetings = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (start, end) = br.readLine.split(" ").map { it.toInt() }
        meetings.add(start to end)
    }

    br.close()
}