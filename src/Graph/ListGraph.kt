package Graph

class ListGraph<Node, Cost>(private val isDirected: Boolean = false) {
    private val adjList: MutableMap<Node, MutableList<Pair<Node, Cost>>> = mutableMapOf()

    fun addEdge(from: Node, to: Node, cost: Cost) {
        createOrAddEdge(from, to, cost)
        if (!isDirected) {
            createOrAddEdge(to, from, cost)
        }
    }

    fun print() {
        adjList.forEach { node, adjList ->
            println()
            println("Node ${node.toString()} makes an edge with")
            adjList.forEach {
                println("\tNode ${it.first.toString()} with an edge weight of = ${it.second.toString()}")
            }
        }
    }

    private fun createOrAddEdge(from: Node, to: Node, cost: Cost) {
        adjList[from]?.let {
            it.add(Pair(to, cost))
            return
        }
        adjList[from] = mutableListOf(Pair(to, cost))
    }
}
