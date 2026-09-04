package com.lessons.seventh


/*
Не решено - превышен лимит времени
Сложность = O(N*M) = O(N^2)
Память = O(M)
*/
fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val segments = ArrayList<Pair<Int, Int>>(n)
    for (i in 0..<n) {
        val (a, b) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        segments.add(a to b)
    }
    val points = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    val segmentsSorted = segments.sortedWith(
        compareBy<Pair<Int, Int>> { it.first }
            .thenBy { it.second }
    )
    val pointsSorted = points.sorted()


    val result = IntArray(m)
    println(result.joinToString(" "))
}