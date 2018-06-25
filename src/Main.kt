import Graph.ListGraph

fun main(args: Array<String>) {
    val graph = ListGraph(5)
    graph.addEdge(0,1, 1)
    graph.addEdge(0,4, 1)
    graph.addEdge(1,2, 1)
    graph.addEdge(1,3, 1)
    graph.addEdge(1,4, 1)
    graph.addEdge(2,3, 1)
    graph.addEdge(3,4, 1)
    graph.dfs()
}
