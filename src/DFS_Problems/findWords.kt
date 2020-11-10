package DFS_Problems

// Word search II on leetCode

fun findWords(board: Array<CharArray>, words: Array<String>): List<String> {
    val mutableListOf = mutableSetOf<String>()

    for (w in words) {
        for (i in board.indices) {
            for (j in board[i].indices) {
                if (board[i][j] == w[0]) {
                    if (containsWordDFS(board, i, j, w)) mutableListOf += w
                }
            }
        }
    }

    return mutableListOf.toMutableList()
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
