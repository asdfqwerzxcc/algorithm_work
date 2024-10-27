import java.lang.Math.abs
import java.util.*

var n = 0
var sum = 0
var col = Array(15){0}

fun main(args : Array<String>) = with(Scanner(System.`in`)){
    n = nextInt()
    dfs(0)
    println(sum)
}

fun dfs(x : Int){
    if(x == n) sum++
    else{
        for(i in 0 until n){
            col[x] = i // x 번째 열의 i 번째 행
            if(check(x))
                dfs(x+1) // 퀸을 놓았다면 다음열로 (열체크 필요 X)
        }
    }
}

fun check(level : Int) : Boolean{
    for(i in 0 until level)
        if(col[i] == col[level] || abs(col[level] - col[i]) == level - i) return false
    // 같은 행에 있거나 대각선에 있으면 false
    return true
}