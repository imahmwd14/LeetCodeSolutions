package DFS_Problems

// Word search problem on LeetCode
fun exist(board: Array<CharArray>, word: String): Boolean {
    for (i in board.indices) {
        for (j in board[i].indices) {
            if (board[i][j] == word[0]) {
                if (containsWordDFS(board, i, j, word)) return true
            }
        }
    }
    return false
}

private fun containsWordDFS(board: Array<CharArray>, i: Int, j: Int, word: String, size: Int = 0): Boolean {
    if (size == word.length) return true
    if (i !in board.indices || j !in board[i].indices || board[i][j] != word[size]) return false

    val temp = board[i][j]
    board[i][j] = ' '

    val hasWord = containsWordDFS(board, i + 1, j, word, size + 1) ||
            containsWordDFS(board, i - 1, j, word, size + 1) ||
            containsWordDFS(board, i, j + 1, word, size + 1) ||
            containsWordDFS(board, i, j - 1, word, size + 1)

    board[i][j] = temp

    return hasWord
}
