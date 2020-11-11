package DFS_Problems

// https://leetcode.com/problems/count-good-nodes-in-binary-tree/


class TreeNode(var `val`: Int) {
    var right: TreeNode? = null
    var left: TreeNode? = null
}


fun goodNodes(root: TreeNode?, v: Int = Int.MIN_VALUE): Int {
    if (root == null) return 0
    return if (root.`val` >= v) 1 + goodNodes(root.left, root.`val`) + goodNodes(root.right, root.`val`)
    else goodNodes(root.left, v) + goodNodes(root.right, v)
}