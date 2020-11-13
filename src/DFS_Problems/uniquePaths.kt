package DFS_Problems

fun main() {
    println(uniquePaths(3, 7))
}

fun uniquePaths(m: Int, n: Int): Int {
    return uniquePaths(m, n, 1, 1)
}

fun uniquePaths(m: Int, n: Int, i: Int, j: Int): Int {
    if (i !in 0..m || j !in 0..n) return 0
    if (i == m && i == n) return 1
    return uniquePaths(m, n, i + 1, j) + uniquePaths(m, n, i, j + 1)
}
