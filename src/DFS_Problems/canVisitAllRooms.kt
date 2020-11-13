package DFS_Problems

import java.util.HashSet

fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
    if (rooms.size == 1 && rooms.first().isEmpty()) return true
    val seen = hashSetOf<Int>().also { it.add(0) }
    rooms[0].forEachIndexed { _, key ->
        if (dfs(rooms, key, seen)) return true
    }
    return false
}

fun dfs(rooms: List<List<Int>>, key: Int, seen: HashSet<Int>): Boolean {
    if (!seen.add(key)) return false
    if (seen.size == rooms.size) return true
    rooms[key].forEach { newKey ->
        if (dfs(rooms, newKey, seen)) return true
    }
    return false
}

