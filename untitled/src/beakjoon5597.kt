fun main() {
    val list = arrayListOf<Int>()
    repeat(28) {
        list.add(readln().toInt())
    }
    val result = arrayListOf<Int>()
    for (i in 1 .. 30) {
        if (i !in list) {
            result.add(i)
        }
    }
    println(result[0])
    println(result[1])
}