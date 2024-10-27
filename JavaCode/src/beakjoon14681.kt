fun main(){
    val x: Int= readLine()!!.toInt()
    val y: Int= readLine()!!.toInt()

    if(x>0 && y>0){
        println(1)
    }
    else if(x<0 &&y>0){
        println(2)
    }
    else if(x<0 && y<0 ){
        println(3)
    }
    else{
        println(4)
    }
}