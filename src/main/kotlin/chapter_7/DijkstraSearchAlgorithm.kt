package chapter_7


// the graph
private val graph: MutableMap<String, MutableMap<String, Double>> = HashMap()
private val processed: MutableList<String> = ArrayList()

private fun dijkstraAlgorithm(
    costs: MutableMap<String, Double>,
    parents: MutableMap<String, String?>
): MutableMap<String, Double>{
    var node = findLowestCostNode(costs)
    while (node != null) {
        val cost = costs[node]
        // Go through all the neighbors of this node
        val neighbors: Map<String, Double> = graph[node]!!
        for (n in neighbors.keys) {
            val newCost = cost!! + neighbors[n]!!
            // If it's cheaper to get to this neighbor by going through this node
            if (costs[n]!! > newCost) {
                // ... update the cost for this node
                costs[n] = newCost
                // This node becomes the new parent for this neighbor.
                parents[n] = node
            }
        }
        // Mark the node as processed
        processed.add(node)

        // Find the next node to process, and loop
        node = findLowestCostNode(costs)
    }
    return  costs // { a: 5, b: 2, fin: 6 }
}

private fun findLowestCostNode(costs: Map<String, Double>): String? {
    var lowestCost = Double.POSITIVE_INFINITY
    var lowestCostNode: String? = null

    // Go through each node
    for ((key, cost) in costs) {
        // If it's the lowest cost so far and hasn't been processed yet...
        if (cost < lowestCost && !processed.contains(key)) {
            // ... set it as the new lowest-cost node.
            lowestCost = cost
            lowestCostNode = key
        }
    }
    return lowestCostNode
}


fun main() {
    graph["start"] = HashMap()
    graph["start"]!!["a"] = 6.0
    graph["start"]!!["b"] = 2.0
    graph["a"] = HashMap()
    graph["a"]!!["fin"] = 1.0
    graph["b"] = HashMap()
    graph["b"]!!["a"] = 3.0
    graph["b"]!!["fin"] = 5.0
    graph["fin"] = HashMap()

    // The costs table
    val costs: MutableMap<String, Double> = HashMap()
    costs["a"] = 6.0
    costs["b"] = 2.0
    costs["fin"] = Double.POSITIVE_INFINITY

    // the parents table
    val parents: MutableMap<String, String?> = HashMap()
    parents["a"] = "start"
    parents["b"] = "start"
    parents["fin"] = null
    println("Cost from the start to each node:")
    println(dijkstraAlgorithm(costs, parents))
}


