import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.collections.LinkedHashSet

fun main()  {
    val bufferedReader= BufferedReader(InputStreamReader(java.lang.System.`in`))
    val set = LinkedHashSet<String>()

    var arr   = bufferedReader.readLine().split(" ")
    for(i in 0 until arr[1].toInt()){
        var number = bufferedReader.readLine()

        if(set.contains(number)){
            set.remove(number)
        }
        set.add(number)
    }

    val it : Iterator<String> = set.iterator()
    var count = 1
    while (it.hasNext()){

        println(it.next())
        if(count==arr[0].toInt()) break
        count++
    }
}