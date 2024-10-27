import java.io.*
import java.util.*

fun main()= with(BufferedReader(InputStreamReader(System.`in`))) {
    val w = BufferedWriter(OutputStreamWriter(System.out))

    for(i in 1..readLine().toInt()) {
        StringTokenizer(readLine()).run{
            val a = nextToken().toInt()
            val b = nextToken().toInt()

            w.write("Case #${i}: ${a} + ${b} = ${a+b}\n")
        }
    }
    w.flush()
    w.close()
    close()
}