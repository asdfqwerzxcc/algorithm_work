fun main() {
    val br = System.`in`.bufferedReader()
    val bw = System.out.bufferedWriter()

    val line = br.readLine().split(' ')
    val size = line[0].toInt()
    val num = line[1].toLong()
    val matrix = Array(size) { br.readLine().split(' ').map { it.toLong() % 1000L }.toLongArray() }

    val sb = StringBuilder()
    for (row in power(matrix, num)) {
        sb.append("${row.joinToString(" ") { it.toString() }}\n")
    }

    bw.write(sb.toString())
    bw.flush()
    bw.close()
    br.close()
}

fun multi(mat1: Array<LongArray>, mat2: Array<LongArray>): Array<LongArray> {
    val size = mat1.size
    val tmp = Array(size) { LongArray(size) }

    for (i in 0 until size) {
        for (j in 0 until size) {
            for (k in 0 until size) {
                tmp[i][j] += mat1[i][k] * mat2[k][j]
                tmp[i][j] %= 1000L
            }
        }
    }

    return tmp
}

fun power(mat: Array<LongArray>, exponent: Long): Array<LongArray> {
    return when(exponent) {
        1L -> mat
        else -> {
            val n = power(mat, exponent / 2)

            if (exponent % 2 == 0L) multi(n, n)
            else multi(multi(n, n), mat)
        }
    }
}