import java.util.PriorityQueue

fun main() {
    val n = readln().toInt()
    val arr = PriorityQueue<Long>()

    repeat(n) {
        arr.add(readln().toLong())
    }

    var answer = 0L
    while (arr.size > 1) {
        val a = arr.poll()
        val b = arr.poll()
        val s = a + b
        arr.add(s)
        answer += s
    }

    println(answer)
}