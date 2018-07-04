class MinHeap<Node>() where Node: Comparable<Node> {
    private var size = 0
    private var items = mutableListOf<Node>()

    fun peek(): Node {
        if (size == 0) throw IllegalStateException()
        return items[0]
    }

    fun poll(): Node {
        if (size == 0) throw IllegalStateException()
        val item = items[0]
        items[0] = items[size -1]
        size--
        heapifyDown()
        return item
    }

    fun add(node: Node) {
        items[size] = node
        size++
        heapifyUp()
    }

    private fun heapifyUp() {
        var index = size - 1
        while (hasParent(size) && parentOf(index) > items[index]) {
            swapNodesAt(getParentIndex(index), index)
            index = getParentIndex(index)
        }
    }

    private fun heapifyDown() {
        var index = 0
        while (hasLeftChild(index)) {
            var smallerChildIndex = leftChildIndex(index)
            if (hasRightChild(index) && rightChild(index) < items[index]) {
                smallerChildIndex = rightChildIndex(index)
            }

            if (items[index] > items[smallerChildIndex]) {
                break
            } else {
                swapNodesAt(index, smallerChildIndex)
                index = smallerChildIndex
            }
        }
    }

    private fun swapNodesAt(index: Int, smallerChildIndex: Int) {
        val temp = items[index]
        items[index] = items[smallerChildIndex]
        items[smallerChildIndex] = temp
    }

    private fun rightChildIndex(index: Int) = index * 2 + 2
    private fun leftChildIndex(index: Int) = index * 2 + 1

    private fun rightChild(index: Int) = items[index * 2 + 2]

    private fun hasRightChild(index: Int) = (index * 2 + 2) < size
    private fun hasLeftChild(index: Int) = index * 2 + 1 < size

    private fun getParentIndex(index: Int) = (index - 1) / 2
    private fun hasParent(index: Int) = getParentIndex(index) >= 0

    private fun parentOf(index: Int) = items[getParentIndex(index)]
}
