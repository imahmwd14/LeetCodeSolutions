package DFS_Problems

import java.util.*

    fun deepestLeavesSum(root: TreeNode?): Int {
        if (root == null) return 0

        val queue: Queue<TreeNode> = LinkedList()

        queue.offer(root)

        var sum = 0

        while (queue.isNotEmpty()) {
            sum = 0

            for (i in 1..queue.size) {
                val node = queue.poll()

                sum += node.`val`

                node.left?.run { queue.offer(this) }
                node.right?.run { queue.offer(this) }
            }
        }
        return sum
    }
