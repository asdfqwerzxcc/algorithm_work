fun main(){
    val extentionList = mutableMapOf<String,Int>()
    repeat(readln().toInt()){
        val extension= readln().split(".")[1]
        if(extentionList.containsKey(extension)) {
            extentionList[extension] = extentionList[extension]!!+1
        }else{
            extentionList.put(extension,1)
        }
    }
    extentionList.toSortedMap().forEach{
        println("${it.key} ${it.value}")
    }
}