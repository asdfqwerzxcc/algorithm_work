fun main(){
    val A:Int= readLine()!!.toInt()
    val B:Int=readLine()!!.toInt()

    println("${A * (B % 10)}")
    println("${A * ((B % 100) / 10)}")
    println("${A * (B / 100)}")
    println("${A * B}")

}