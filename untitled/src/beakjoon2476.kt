import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val list = mutableListOf<Int>()
    val n = readLine().toInt()

    repeat(n) {
        var arr = IntArray(7) { 0 }
        var max = 0

        readLine()
                .split(" ")
                .forEach { it ->
                    val dice = it.toInt()

                    if (max < dice) max = dice

                    if (arr[dice] != 0) {
                        arr[dice] += 1
                    } else {
                        arr[dice] = 1
                    }
                }

        when {
            arr.contains(3) -> {
                list.add(10_000 + arr.indexOf(3) * 1_000)
            }
            arr.contains(2) -> {
                list.add(1_000 + arr.indexOf(2) * 100)
            }
            else -> {
                list.add(max * 100)
            }
        }
    }

    println(list.maxOf { it })
}