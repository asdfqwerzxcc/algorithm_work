import java.util.*

fun main() {
    val sc = Scanner(System.`in`)
    val n = sc.nextInt()
    val m = sc.nextInt()
    var min = m
    var sum = 0
    var count = 0

    for (i in n..m) {
        if (calcDivisor(i)) {
            count++
            sum += i
            if (i < min) {
                min = i
            }
        }
    }

    if (count == 0) {
        println("-1")
    } else {
        println(sum)
        println(min)
    }
}

fun calcDivisor(n: Int): Boolean {
    var dCount = 0
    for (i in 1 until(n)) {
        if (n % i == 0) {
            dCount++
        }
    }

    return dCount == 1
}
