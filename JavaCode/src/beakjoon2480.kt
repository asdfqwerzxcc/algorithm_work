fun main(){
    val input: List<Int> =readLine()!!.split(" ").map { it.toInt() }
    var total=0
    if(input[0]==input[1] &&input[0]==input[2]){
        total= 10000+input[1]*1000
    }
    else if(input[0]==input[1] || input[0]==input[2]){
        total=1000+input[0]*100
    }
    else if(input[1]==input[2]){
        total=1000+input[1]*100
    }
    else{
        total= input.max()*100
    }
    print("$total")
}
