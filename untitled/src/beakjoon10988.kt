fun main() {
    val word = readLine()!!.toString()

    if (word == word.reversed()) {
        print("1")
    } else {
        print("0")
    }
}