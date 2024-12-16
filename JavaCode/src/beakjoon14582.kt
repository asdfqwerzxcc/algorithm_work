fun main(){
    val sc = java.util.Scanner(System.`in`)

    val teamA = sc.nextLine().split(" ").map { it.toInt() }
    val teamB = sc.nextLine().split(" ").map { it.toInt() }

    var score = 0
    for (i in teamA.indices) {
        score += teamA[i]
        if (score > 0) {
            println("Yes")
            return
        }
        score -= teamB[i]
    }
    println("No")

}