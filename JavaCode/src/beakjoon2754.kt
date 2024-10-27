import java.io.BufferedReader
import java.io.InputStreamReader

fun main(args: Array<String>) = with(BufferedReader(InputStreamReader(System.`in`))) {
    val grade = readLine()

    println(
            String.format("%.1f",
                    when (grade[0]) {
                        'A' -> 4.3f + gradeIndicator(grade[1])
                        'B' -> 3.3f + gradeIndicator(grade[1])
                        'C' -> 2.3f + gradeIndicator(grade[1])
                        'D' -> 1.3f + gradeIndicator(grade[1])
                        else -> 0.0f
                    }
            )
    )
}

fun gradeIndicator(ind: Char): Float = when(ind) {
    '+' -> 0.0f
    '0' -> -0.3f
    else -> -0.6f
}