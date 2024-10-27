fun main() {
    val input = readLine()!!.split(" ").map { it.toInt() }
    val sortedInput = input.sorted()
    println(sortedInput.joinToString(" "))
}