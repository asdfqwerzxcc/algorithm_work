import java.util.*
import java.lang.StringBuilder
fun main(){
    val str = readLine()!!
    val sb=StringBuilder()
    val stack= Stack<Char>()
    str.forEach{
        if(it in 'A'..'Z'){
            sb.append(it)
// 연산자의 경우
            when (it) {
                // +, -는 괄호 밖이라면 가장 우선순위가 낮음
                // 괄호를 제외한 스택에 쌓여있는 모든 연산자 제거 후 스택에 추가
                '+', '-' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop())
                    }
                    stack.push(it)
                }
                // *, /는 +, -보다 우선순위가 높기 때문에 스택의 *, /제거 후 +, -위에 추가
                '*', '/' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(' && stack.peek() != '-' && stack.peek() != '+') {
                        sb.append(stack.pop())
                    }
                    stack.push(it)
                }
                // 스택에 괄호 추가 -> 괄호 내부
                '(' -> {
                    stack.push(it)
                }
                // 닫는 괄호라면 괄호 내부 연산 문자열에 추가
                ')' -> {
                    while (stack.isNotEmpty() && stack.peek() != '(') {
                        sb.append(stack.pop())
                    }
                    if (stack.isNotEmpty() && stack.peek() == '(') {
                        stack.pop()
                    }
                }
            }
        }
    }
    // 스택에 남아있는 연산자 제거
    while (stack.isNotEmpty()) {
        sb.append(stack.pop())
    }

    println(sb)
}