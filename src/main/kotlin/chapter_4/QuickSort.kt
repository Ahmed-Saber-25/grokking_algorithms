package chapter_4

import java.util.function.Function
import java.util.stream.Collectors
import java.util.stream.Stream


private fun quicksort(list: List<Int>): List<Int> {
    return if (list.size < 2) {
        // base case, arrays with 0 or 1 element are already "sorted"
        list
        } else {
        // recursive case
        val pivot = list[0]

        // sub-array of all the elements lessList than the pivot
        val lessList = list.stream().skip(1).filter { element: Int -> element <= pivot }
            .collect(Collectors.toList())

        // sub-array of all the elements greaterList than the pivot
        val greaterList = list.stream().skip(1).filter { element: Int -> element > pivot }
            .collect(Collectors.toList())
        Stream.of(
            quicksort(lessList).stream(),
            Stream.of(pivot),
            quicksort(greaterList).stream()
        )
            .flatMap(Function.identity()).collect(Collectors.toList())
    }
}

fun main() {
    println(quicksort(listOf(10, 5, 2, 3))) // [2, 3, 5, 10]
}


