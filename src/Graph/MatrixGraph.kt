package Graph

class VertexOutOfBoundException(override var message:String): Exception(message)

class MatrixGraph(private val nodes: Int){
    private var  adjMatrix: Array<IntArray> = Array(nodes, { _ -> IntArray(nodes)})

    fun addEdge(from: Int, to: Int, value: Int) {
        if (from >= nodes || to >= nodes) {
            throw VertexOutOfBoundException("Either $from or $to is greater that current vertex in the graph which is $nodes")
        }
        adjMatrix[from][to] = value
    }

    fun printGraph() {
        adjMatrix.forEach {
            println()
            it.forEach {
                print(it)
            }
        }
    }
}
