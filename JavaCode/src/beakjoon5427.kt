var T = 0
var answer = 0

var curX = 0
var curY = 0
var curTime =0

var personX = 0
var personY = 0

val dx = intArrayOf(1,-1,0,0)
val dy = intArrayOf(0,0,1,-1)

val building = Array(1001){CharArray(1001) }
val fireVisited = Array(1001){IntArray(1001) { 0 } }    //몇 초에 불이 방문되었는지를 저장 (0이라면 방문 X)
val personVisited = Array(1001){BooleanArray(1001) {false} } //상근이의 방문 확인을 위한 배열

val deque : ArrayDeque<Pair<Pair<Int, Int>, Int>> = ArrayDeque<Pair<Pair<Int,Int>,Int>>()

fun main(){
    T = readln().toInt()

    for(t in 0 until T){
        answer = 0
        deque.clear()

        val (w, h) = readln().split(' ').map{ it.toInt() }

        for(i in 0  until h){
            readln().forEachIndexed { j, c ->
                building[i][j] = c
                fireVisited[i][j] = 0
                personVisited[i][j] = false

                if(c == '*') {   //불일 경우
                    deque.add(Pair(Pair(i, j), 1))
                    fireVisited[i][j] = 1
                }
                else if(c == '@'){  //상근일 경우, 상근이의 초기 x,y 좌표 저장
                    personX = i
                    personY = j
                }
            }
        }

        //불에 대한 방문 처리
        while(deque.isNotEmpty()){
            curX = deque.first().first.first
            curY = deque.first().first.second
            curTime = deque.first().second

            deque.removeFirst()

            for(i in 0 until 4){
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) {    //불은 빌딩을 벗어나서는 안됨
                    continue
                }
                if(fireVisited[nx][ny] == 0 && building[nx][ny] != '#'){    //방문하지 않고, 벽이 아닌 노드라면 방문처리
                    fireVisited[nx][ny] = curTime + 1
                    deque.add(Pair(Pair(nx,ny), curTime + 1))
                }
            }
        }

        deque.add(Pair(Pair(personX, personY), 1))
        personVisited[personX][personY] = true

        //상근이에 대한 방문 처리
        while(deque.isNotEmpty()){
            curX = deque.first().first.first
            curY = deque.first().first.second
            curTime = deque.first().second

            deque.removeFirst()
            if(answer != 0) break

            for(i in 0 until 4){
                val nx = curX + dx[i]
                val ny = curY + dy[i]
                if(nx < 0 || nx >= h || ny < 0 || ny >= w) {    //상근의 탈출 조건
                    answer = curTime
                    break
                } 
                //다음 노드가 벽이 아닌 노드 and (다음 노드가 불이 지나갈 곳이 아니거나, 상근이가 불보다 더 빨리 지나갈 곳이라면)
                if(building[nx][ny] != '#' && (fireVisited[nx][ny] == 0 || fireVisited[nx][ny] > curTime + 1)){
                    if(!personVisited[nx][ny]) {
                        personVisited[nx][ny] = true
                        deque.add(Pair(Pair(nx,ny), curTime + 1))
                    }
                }
            }
        }

        if(answer == 0) println("IMPOSSIBLE") else println(answer)
    }

}