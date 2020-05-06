package subtask6

import java.lang.StringBuilder

class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {

        val mapOfTrees = mutableMapOf<Int, MutableList<Node>>()

        return generateTrees(count, mapOfTrees)?.joinToString(
            separator = "",
            prefix = "[",
            postfix = "]"
        ) { transform(it.toString(), count) } ?: "[]"
    }

    private fun transform(stringViewOfNode: String, count: Int): String {
        val visualViewOfTree = StringBuilder("[0")
        var nodesNumber = 1

        for ((index, value) in stringViewOfNode.toCharArray().withIndex()) {
            if (value == '0') {
                nodesNumber++
            }
            if (nodesNumber == count && count != 1) {
                visualViewOfTree.append(",").append(stringViewOfNode.substring(0, index + 1))
                break
            }
        }
        return visualViewOfTree.append("]").toString()
    }

    private fun generateTrees(
        number: Int,
        mapOfTrees: MutableMap<Int, MutableList<Node>>
    ): MutableList<Node>? {

        if (!mapOfTrees.containsKey(number)) {

            val tree = mutableListOf<Node>()

            if (number == 1) {
                tree.add(Node())

            } else if (number % 2 == 1) {

                for (leftNode in 0 until number) {
                    val treeOfLeftNodes = generateTrees(leftNode, mapOfTrees) ?: return null

                    for (left in treeOfLeftNodes) {
                        val treeOfRightNodes = generateTrees(
                            number - leftNode - 1,
                            mapOfTrees
                        ) ?: return null

                        for (right in treeOfRightNodes) {
                            tree.add(Node(left, right))
                        }
                    }
                }
            }
            mapOfTrees[number] = tree
        }
        return mapOfTrees[number]
    }
}

class Node(private var leftNode: Node? = null, private var rightNode: Node? = null) {

    override fun toString(): String {
        return if (leftNode != null && rightNode != null) {
            "0,0,$leftNode,$rightNode"
        } else {
            "null,null"
        }
    }
}