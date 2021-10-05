package chapter_9

private fun getLongestCommonSubSequence(wordA: String, wordB: String) {
    val cell = Array(wordA.length) { IntArray(wordB.length) }
    for (i in wordA.indices) {
        for (j in wordB.indices) {
            // The letters match
            if (wordA[i] == wordB[j]) {
                if (i > 0 && j > 0) {
                    cell[i][j] = cell[i - 1][j - 1] + 1
                } else {
                    cell[i][j] = 1
                }
            } else {
                // The letters don't match.
                if (i > 0 && j > 0) {
                    cell[i][j] = Math.max(cell[i - 1][j], cell[i][j - 1])
                } else {
                    cell[i][j] = 0
                }
            }
        }
    }
    printResult(cell)
}

private fun printResult(arr: Array<IntArray>) {
    for (row in arr) {
        println(row.contentToString())
    }
}

fun main() {
    val wordA = "hish"
    val wordB = "fish"
    getLongestCommonSubSequence(wordA, wordB)
//      [0, 0, 0, 1]
//      [0, 1, 1, 1]
//      [0, 1, 2, 2]
//      [0, 1, 2, 3]
}

