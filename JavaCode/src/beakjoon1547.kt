import java.io.BufferedReader
import java.io.InputStreamReader
fun main(){
    val reader = BufferedReader(InputStreamReader(System.`in`))
    val cup = mutableListOf(true,false,false)

    repeat(reader.readLine().toInt()){
        val (a,b) =reader.readLine().split(" ").map{it.toInt()-1}
        cup[a]=cup[b].also {cup[b]=cup[a]}
    }

    println(cup.indexOf(true)+1)
}