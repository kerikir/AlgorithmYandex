package com.lessons.seventh


/*
Не решено - превышен лимит времени
Сложность = O(N*M) = O(N^2)
Память = O(M)
*/
fun main() {
    val (n, m) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
    val segments = ArrayList<Pair<Int, Int>>(n)
    for (i in segments.indices) {
        val (a, b) = readln().trim().split(Regex("\\s+")).map { it.toInt() }
        segments[i] = a to b
    }
    val points = readln().trim().split(Regex("\\s+")).map { it.toInt() }

    
}