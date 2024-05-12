import java.util.Scanner

fun main(args: Array<String>)=with(Scanner(System.`in`)){
    val maxArray = arrayListOf<Int>()
    var maxLine=0
    var maxNum=0

    for(i in 0 until 9){
        val inputNum= nextInt()
        maxArray.add(inputNum)

        if(maxNum<maxArray[i]){
            maxNum=maxArray[i]
            maxLine=i
        }
    }
    println("$maxNum\n${maxLine+1}")
}