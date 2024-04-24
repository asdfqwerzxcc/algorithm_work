import java.util.*

fun main(args:Array<String>){
    val s= Scanner(System.`in`)
    var k=s.nextInt()
    var n=s.nextInt()
    var m=s.nextInt()

    var sum=k*n-m

    if(sum>0)print(sum)
    else print(0)
}