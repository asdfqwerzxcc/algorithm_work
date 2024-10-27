fun main() {
    val n = readLine()

    for(i in 1..n!!.toInt()){
        val (a,b) = readLine()!!.split(" ")

        println(a.toInt() + b.toInt())
    }
}