fun main(){
    var total=0
    for( i in 0..4){
        var a= readLine()!!.toInt()
        if (a <40){
            a=40
        }
        total+=a
    }
    println(total/5)
}
