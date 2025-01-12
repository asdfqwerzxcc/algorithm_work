fun main() {
    val input = readln().toLong()
    var sum = 0L
    var i = 1L
    var count = 0
    while (true) {
        if (input == 1L) {
            count = 2
            break
        }
        if (input > sum) {
            sum += i
            i++
            count++
        } else if (input == sum) {
            count++
            break
        } else {
            break
        }
    }
    println(count - 1)
}