package chapter_2

import java.util.*


fun findSmallest(array: List<Int>):Int{
    var smallest = array[0]
    var smallestIndex = 0
    for (i in array.indices){
        if (array[i]<smallest) {
            smallest = array[i]
            smallestIndex = i
        }
    }
    return smallestIndex
}
fun selectionSort(array: MutableList<Int>): ArrayList<Int> {

    var sortedArray = ArrayList<Int>(array.size)
    for (i in 0 until array.size){
        var smallest = findSmallest(array)
        sortedArray.add(array[smallest])
        array.removeAt(smallest)
    }
    return sortedArray
    }
fun main() {
    println("your sorted array is : ${selectionSort(mutableListOf(5, 3, 6, 2, 10)) }")
}


