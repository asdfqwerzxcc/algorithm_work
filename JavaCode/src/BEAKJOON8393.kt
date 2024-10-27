import java.util.Scanner
fun main(){
    val sc : Scanner = Scanner(System.`in`)


    var n = sc.nextInt()
    var sum:Int = 0

    for( i in 1..n ){
        sum += i
    }
    println(sum)

}