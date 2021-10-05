package chapter_3

import kotlin.system.exitProcess

fun factorial(i:Int):Int{
    return if (i==1)
        1
    else
        i * factorial(i-1)
}

fun countDown(i:Int){
    println(i)
    if (i<=1)
        exitProcess(0)
    else
        countDown(i-1)
}



fun main(){
    println( factorial(5))
    println( countDown(5))
}