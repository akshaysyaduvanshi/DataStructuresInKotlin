package Graph

class Edge(val vertex: Vertex, val distance: Int = 1)
class Vertex(val id: Int, val edges: MutableList<Edge> = mutableListOf())
