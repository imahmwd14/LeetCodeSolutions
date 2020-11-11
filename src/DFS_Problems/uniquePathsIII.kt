package DFS_Problems

// https://leetcode.com/problems/unique-paths-iii/

fun uniquePathsIII(grid: Array<IntArray>): Int {
    var theOne: Pair<Int, Int> = 0 to 0

    var stepsNeeded = 0

    grid.forEachIndexed { index, ints ->
        ints.forEachIndexed { j, i ->
            if (i == 1)
                theOne = index to j
            if (i == 0) stepsNeeded++
        }
    }

    val (i, j) = theOne

    val count = intArrayOf(0)

    countUniquePaths(grid, i, j, count, stepsNeeded)

    return count[0]
}

fun countUniquePaths(grid: Array<IntArray>, i: Int, j: Int, count: IntArray, stepsNeeded: Int) {
    if (i !in 0..grid.lastIndex || j !in 0..grid[i].lastIndex || grid[i][j] < 0) return
    if (grid[i][j] == 1) grid[i][j] = -9

    if (grid[i][j] == 2) {
        if (stepsNeeded < 0) {
            count[0] += 1
        }
        return
    }

    grid[i][j] = -1

    val stepsNeeded1 = stepsNeeded - 1

    countUniquePaths(grid, i + 1, j, count, stepsNeeded1)
    countUniquePaths(grid, i - 1, j, count, stepsNeeded1)
    countUniquePaths(grid, i, j + 1, count, stepsNeeded1)
    countUniquePaths(grid, i, j - 1, count, stepsNeeded1)

    grid[i][j] = 0
}

