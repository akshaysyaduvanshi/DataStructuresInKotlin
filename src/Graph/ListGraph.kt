package Graph

import Queue.Queue

class ListGraph(nodes: Int) {
    private val adjacencyList: Array<Vertex> = Array(nodes) {i -> Vertex(i)}

    fun addEdge(from: Int, to: Int, value: Int, twoWayEdge: Boolean = true) {
        addEdgeInternal(from, to, value)
        if (twoWayEdge) {
            addEdgeInternal(to, from, value)
        }
    }

    fun printGraph() {
        for(i in 0 until adjacencyList.size) {
            print("Adjacency matrix of the vertex $i")
            print(" head")
            adjacencyList[i].edges.forEach {
                print(" -> ${it.vertex.id}")
            }
            println()
        }
    }

    fun bfs(): MutableList<Int> {
        val visitedArray = Array(adjacencyList.size) {false}
        var queue = Queue(mutableListOf<Vertex>())
        queue.enqueue(adjacencyList[0])
        val dfsTraversal = mutableListOf<Int>()
        while (!queue.isEmpty()) {
            val node = queue.dequeue()!!
            if (visitedArray[node.id]) { continue}
            dfsTraversal.add(node.id)
            visitedArray[node.id] = true
            node.edges.forEach { queue.enqueue(it.vertex)}
        }
        dfsTraversal.forEach {
            print(it)
        }
        return  dfsTraversal
    }

    fun dfs(): MutableList<Int> {
        val dfsTraversal = mutableListOf<Int>()
        val visitedArray = Array(adjacencyList.size) {false}

        dfsUtil(adjacencyList[0], visitedArray)

        dfsTraversal.forEach {
            print(it)
        }
        return  dfsTraversal

    }

    private fun dfsUtil(vertex: Vertex, visited: Array<Boolean>) {
        print(vertex.id)
        visited[vertex.id] = true
        vertex.edges.forEach {
            if (!visited[it.vertex.id]) {
                dfsUtil(it.vertex, visited)
            }
        }
    }


    private fun addEdgeInternal(from: Int, to: Int,  value: Int) {
        val fromNode = adjacencyList[from]
        val toNode = adjacencyList[to]
        fromNode.edges.add(Edge(toNode, value))
    }
}
