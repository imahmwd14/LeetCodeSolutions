import java.util.*

class TreeNode(var `val`: Int, var left: TreeNode? = null, var right: TreeNode? = null) {
}

fun increasingBST(root: TreeNode?): TreeNode? {
    val items: Queue<Int> = LinkedList<Int>().also { inOrder(root, it) }
    val rootNode = TreeNode(items.poll())
    var curr: TreeNode? = rootNode
    while (!items.isEmpty()) curr = curr?.run { this.right = TreeNode(items.poll()); right }
    return rootNode
}

fun inOrder(root: TreeNode?, linkedList: LinkedList<Int>) {
    if (root == null) return
    root.run {
        inOrder(left, linkedList)
        linkedList.offer(`val`)
        inOrder(right, linkedList)
    }
}
