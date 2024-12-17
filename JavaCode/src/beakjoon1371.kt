import java.util.Scanner

fun main(args: Array<String>) = with(Scanner(System.`in`)) {
    var charIdx = IntArray(26) { 0 }
    var max = 0

    while (hasNextLine()) {
        val str = nextLine()

        str.forEach {
            if (it in 'a'..'z') {
                charIdx[it - 'a']++
                if (max < charIdx[it - 'a']) max = charIdx[it - 'a']
            }
        }
    }

    charIdx.forEachIndexed { index, int ->
        if (max == int) print('a' + index)
    }
}