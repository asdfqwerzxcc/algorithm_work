fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val num = br.readLine().toInt()

    var cnt = 0
    var start = 1
    var end = 2

    while (start<end) {
        var sum = 0
        for(i in start .. end) {
            sum += i
        }
        if(sum == num) {
            cnt++
        }
        if(sum > num) {
            start++
        } else {
            end++
        }
    }

    bw.write("${cnt+1}")
    bw.flush()
    bw.close()
    br.close()
}