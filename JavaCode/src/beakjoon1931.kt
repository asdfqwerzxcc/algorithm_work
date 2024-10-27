import java.io.BufferedReader
import java.io.InputStreamReader

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))

    val n = br.readLine().toInt()

    val meetings = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (start, end) = br.readLine().split(" ").map { it.toInt() }
        meetings.add(start to end)
    }

    val sortedMeetings = meetings.sortedBy { it.first }.sortedBy { it.second }

    // 결과 : maxMeetingCnt, 최대 회의의 수
    var maxMeetingCnt = 0
    var endTime = 0

    for (meeting in sortedMeetings) {
        if (meeting.first >= endTime) {
            endTime = meeting.second
            maxMeetingCnt++
        }
    }

    println(maxMeetingCnt)
    br.close()
}