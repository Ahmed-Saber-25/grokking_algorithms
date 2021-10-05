package chapter_5


private val votedPersons: MutableMap<String, Boolean> = HashMap()

private fun checkVoter(name: String) {
    if (votedPersons.containsKey(name)) {
        println("kick them out!")
    } else {
        votedPersons[name] = true
        println("let them vote!")
    }
}

fun main() {
    checkVoter("tom") // let them vote!
    checkVoter("mike") // let them vote!
    checkVoter("mike") // kick them out!
}