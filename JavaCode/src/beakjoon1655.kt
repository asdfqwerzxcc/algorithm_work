// [백준] 1655. 가운데를 말해요 (Kotlin)
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*
//
var realine: Int = 0
val maxHeap = PriorityQueue<Int>(Collections.reverseOrder())
val minHeap = PriorityQueue<Int>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    realine = readLine().toInt()
    val sb = StringBuilder()

    for(i in 0 until realine){
        val cur = readLine().toInt()

        if(maxHeap.size == minHeap.size){
            maxHeap.offer(cur)
        }
        else{
            minHeap.offer(cur)
        }
        if (!minHeap.isEmpty() && !maxHeap.isEmpty()) {
            if (minHeap.peek()!! < maxHeap.peek()!!) {
                // 균형 맞추기 위해 swap
                val tmp = minHeap.poll()
                minHeap.offer(maxHeap.poll())
                maxHeap.offer(tmp)
            }
        }
        sb.append("${maxHeap.peek()!!} \n")
    }

    println(sb)
}