package chapter_1

fun binarySearch(list: List<Int>, searchItem: Int): Int {
    val sortedList = list.sorted()
    var start = 0
    var end = sortedList.size - 1
    while (start <= end) {
        val center = (start + end)/2
        val guess = sortedList[center]
        when {
            guess == searchItem -> return center
            guess > searchItem -> {
                end = center - 1
            }
            else -> {
                start = center + 1
            }
        }
    }
    return -1
}
fun main() {
   println("your search item is at position : ${binarySearch(listOf(1,2,3,4,7,9,6),7) }")
}