import java.util.Scanner

fun main()= with(Scanner(System.`in`)){
    for(i in 1..nextInt()) println("Case #$i: ${nextInt()+nextInt()}")
}