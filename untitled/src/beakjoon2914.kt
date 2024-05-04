import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))){
    val copyrights = readLine().split(" ").map { it.toInt() }
    println(copyrights[0] * (copyrights[1] - 1) + 1)
}