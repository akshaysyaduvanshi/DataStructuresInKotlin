import Graph.ListGraph

fun main(args: Array<String>) {
    val graph = ListGraph<Int, Int>()
    graph.addEdge(0, 1, 10)
    graph.addEdge(0, 4, 20)
    graph.addEdge(1, 2, 30)
    graph.addEdge(1, 3, 40)
    graph.addEdge(1, 4, 50)
    graph.addEdge(2, 3, 60)
    graph.addEdge(3, 4, 70)
    graph.print()
}
