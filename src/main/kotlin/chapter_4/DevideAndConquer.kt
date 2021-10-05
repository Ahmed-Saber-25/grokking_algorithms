package chapter_4

fun sumListUsingRecursion(list: List<Int>):Int{
    return if(list.isEmpty())
        0
    else
        list[0]+ sumListUsingRecursion(list.drop(1))
}

fun countListUsingRecursion(list: List<Int>):Int{
    return if(list.isEmpty())
        0
    else
        1 + countListUsingRecursion(list.drop(1))
}

fun maxNumberInList(list:List<Int>):Int{
    return if (list.size == 2){
        if (list[0] > list[1])
            list[0]
        else
            list[1]
    }else{
        val subMax = maxNumberInList(list.drop(1))
        if (list[0] > subMax)
            list[0]
        else
            subMax
    }
}

fun main(){
    println(sumListUsingRecursion(listOf(1,2,3,4,5)))
    println(countListUsingRecursion(listOf(1,2,3,4,5)))
    println(maxNumberInList(listOf(5,4,3,2,1)))
}