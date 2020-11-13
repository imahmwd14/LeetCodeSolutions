package DFS_Problems

fun minPathSum(grid: Array<IntArray>): Int {
    val minimumSum = intArrayOf(Int.MAX_VALUE)
    minPathSum(grid, 0, 0, minimumSum)
    return minimumSum[0]
}

fun minPathSum(grid: Array<IntArray>, i: Int, j: Int, minimumSum: IntArray, sum: Int = 0) {
    if (i == grid.lastIndex && j == grid.lastIndex) minimumSum[0] = Math.min(sum, minimumSum[0])
    if (i !in 0..grid.lastIndex || j !in 0..grid[i].lastIndex) return

    minPathSum(grid, i + 1, j, minimumSum, sum + grid[i][j])
    minPathSum(grid, i, j + 1, minimumSum, sum + grid[i][j])
}
