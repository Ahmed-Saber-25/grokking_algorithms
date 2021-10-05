package chapter_5


fun main() {
    val book: MutableMap<String, Double> = HashMap()

    // an apple costs 67 cents
    book["apple"] = 0.67
    // milk costs $1.49
    book["milk"] = 1.49
    book["avocado"] = 1.49
    println(book) // {apple=0.67, avocado=1.49, milk=1.49}
}