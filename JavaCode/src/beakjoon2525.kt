fun main(){
    val input: MutableList<Int> = readLine()!!.split(" ").map{it.toInt()}.toMutableList()

    val c:Int=readLine()!!.toInt()
    val total=input[1]+c
    if(total>=60){
        val plushour=total/60
        input[1]=total%60
        if(input[0]+plushour>=24){
            input[0]=(input[0]+plushour)%24
        }else {
            input[0]+=plushour
        }
    }else{
        input[1]+=c
    }
    println("${input[0]} ${input[1]}")
}
