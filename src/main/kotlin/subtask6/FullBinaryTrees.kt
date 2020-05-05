package subtask6

import java.lang.StringBuilder
import java.util.*
import kotlin.collections.HashMap


class FullBinaryTrees {

    fun stringForNodeCount(count: Int): String {
//        if (count % 2 == 0 || count <= 0) {
//            return "[]"
//        }
//        val root = Node().apply { getInside(count) }
//        val string = root.getChildren()
//        return string.toString()


        return allPossibleFBT(count)?.joinToString(
            separator = "",
            prefix = "[",
            postfix = "]"
        ) { transform(it.toString(), count) } ?: "[]"
    }

    private fun transform(string: String, count: Int): String {
        val sb = StringBuilder("[0")
        var counter = 1
        for ((index, value) in string.toCharArray().withIndex()) {
            if (value == '0') {
                counter++
            }
            if (counter == count && count != 1) {
                sb.append(",").append(string.substring(0, index + 1))
                break
            }
        }
        return sb.append("]").toString()
    }

    var memo = HashMap<Int?, LinkedList<Node>?>()

    private fun allPossibleFBT(N: Int): LinkedList<Node>? {
        if (!memo.containsKey(N)) {
            val ans = LinkedList<Node>()
            if (N == 1) {
                ans.add(Node())
            } else if (N % 2 == 1) {
                for (x in 0 until N) {
                    val y = N - 1 - x
                    for (left in allPossibleFBT(x)!!) {
                        for (right in allPossibleFBT(y)!!) {
                            val bns = Node()
                            bns.leftNode = left
                            bns.rightNode = right
                            ans.add(bns)
                        }
                    }
                }
            }
            memo[N] = ans
        }
        return memo[N]
    }

//    fun stringForNodeCount(count: Int): String {
//
//        val listOfNodes = mutableListOf<Node>()
//        val root = Node()
//        var currentNode = root
//        var currentRoot: Node? = null
//        var numberOfNodes = 0
//
//        while (root.color == Node.WHITE) { //change
//
//            currentNode.getInside()
//            numberOfNodes += 2
//
//            if (numberOfNodes == count) {
//                if (currentRoot != null) {
//                    currentNode = currentRoot
//                } else {
//                    break
//                }
//            }
//
//            currentRoot = currentNode
//            currentNode = when {
//
//                currentNode.leftNode?.color == Node.WHITE -> {
//                    currentNode.leftNode!!
//                }
//                currentNode.rightNode?.color == Node.WHITE -> {
//                    currentNode.rightNode!!
//                }
//                else -> {
//                    currentRoot
//                }
//            }
//        }
//
//        return listOfNodes.joinToString { " " }
//    }
}

class Node {
//    var color = WHITE

    var leftNode: Node? = null
    var rightNode: Node? = null
    override fun toString(): String {
        return if (leftNode != null && rightNode != null) {
            "0,0,$leftNode,$rightNode"
        } else {
            "null,null"
        }
    }


//    fun getInside(remainder: Int) {
//        leftNode = Node()
//        rightNode = Node()
//        if (remainder != 0) {
//            leftNode?.getInside(remainder - 2)
//            rightNode?.getInside(remainder - 2)
//        } else {
//
//        }
//    }
//
//    fun getChildren(): List<String> {
//        val result = mutableListOf<String>()
//        result.add(if (leftNode != null) "0" else "null")
//        result.add(if (rightNode != null) "0" else "null")
//        leftNode?.getChildren()?.let { result.addAll(it) }
//        rightNode?.getChildren()?.let { result.addAll(it) }
//        return result
//    }

//    fun getInside() {
//        if (color == WHITE) {
//            color = BLACK
//            leftNode = Node()
//            rightNode = Node()
//        }
//    }
//
//    companion object Color {
//        const val WHITE = "white"
//        const val BLACK = "black"
//    }
}