package DFS_Problems

fun rangeSumBST(root: TreeNode?, low: Int, high: Int, sum: IntArray = intArrayOf(0)): Int {
    if (root == null) return 0
    return (if (root.`val` in low..high) root.`val` else 0) +
            rangeSumBST(root.left, low, high) +
            rangeSumBST(root.right, low, high)
}