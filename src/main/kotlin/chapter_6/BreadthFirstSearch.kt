package chapter_6

import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.HashMap
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.MutableMap
import kotlin.collections.emptyList
import kotlin.collections.set


private val graph: MutableMap<String, List<String>> = HashMap()

private fun search(name: String): Boolean {
    val searchQueue: Queue<String> = ArrayDeque(graph[name])
    // This list is how you keep track of which people you've searched before.
    val searched: MutableList<String> = ArrayList()
    while (!searchQueue.isEmpty()) {
        val person = searchQueue.poll()
        // Only chapter_6.search this person if you haven't already searched them
        if (!searched.contains(person)) {
            if (isThisPersonSeller(person)) {
                println("$person is a mango seller!")
            } else {
                searchQueue.addAll(graph[person]!!)
                // Marks this person as searched
                searched.add(person)
            }
        }
    }
    return false
}

private fun isThisPersonSeller(name: String): Boolean {
    return name.endsWith("m")
}

fun main() {
    graph["you"] = listOf("alice", "bob", "claire")
    graph["bob"] = listOf("anuj", "peggy")
    graph["alice"] = listOf("peggy")
    graph["claire"] = listOf("thom", "jonny")
    graph["anuj"] = emptyList()
    graph["peggy"] = emptyList()
    graph["thom"] = emptyList()
    graph["jonny"] = emptyList()
    search("you")
}