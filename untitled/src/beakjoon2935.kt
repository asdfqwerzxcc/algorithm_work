import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val num = readLine().toBigInteger()
    val operator = readLine()
    val num2 = readLine().toBigInteger()

    when (operator) {
        "*" -> println(num * num2)
        else -> println(num + num2)
    }
}