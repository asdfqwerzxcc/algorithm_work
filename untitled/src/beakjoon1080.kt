
fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val (rows, cols) = br.readLine().split(' ').map { it.toInt() }
    val matrix = Array(rows) { br.readLine().map { it - '0' }.toIntArray() }
    val goal = Array(rows) { br.readLine().map { it - '0' }.toIntArray() }

    var cnt = 0
    for(i in 0 until rows - 2) {
        for(j in 0 until cols - 2) {
            if(matrix[i][j] != goal[i][j]) {
                cnt++
                for(r in i until i + 3) {
                    for(c in j until j + 3) {
                        matrix[r][c] = if(matrix[r][c] == 1) 0 else 1
                    }
                }
            }
        }
    }

    for(i in 0 until rows) {
        for(j in 0 until cols) {
            if(matrix[i][j] != goal[i][j]) cnt = -1
        }
        if(cnt == -1) break
    }

    bw.write("$cnt")
    bw.flush()
    bw.close()
    br.close()
}