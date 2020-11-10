package dynamicProgramming

fun superEggDrop(K: Int, N: Int, dp: Array<Array<Int?>> = Array<Array<Int?>>(K + 1) { arrayOfNulls(N + 1) }): Int {
    if (K == 1 || N in 0..1) return N
    if (dp[K][N] != null) return dp[K][N]!!

    var min: Int = Int.MAX_VALUE
    for (i in 1..N) {
        min = Math.min(
            min,
            Math.max(superEggDrop(K, N - i, dp), superEggDrop(K - 1, i - 1, dp))
        )
    }
    dp[K][N] = min + 1
    return dp[K][N]!!
}

fun main() {
    println(superEggDrop(8, 5000))
}