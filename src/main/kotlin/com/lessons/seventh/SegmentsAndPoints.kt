package com.lessons.seventh

import kotlin.math.max
import kotlin.math.min


/*
Не решено - превышен лимит времени
Сложность = O(N*M) = O(N^2)
Память = O(M)
*/
fun main() {
    val (n, m) = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }
    val segments = ArrayList<Pair<Int, Int>>(n)
    for (i in 0..n - 1) {
        val (a, b) = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }
        segments.add(min(a, b) to max(a, b))
    }
    val points = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }

    val segmentsSorted = segments.sortedWith(
        compareBy<Pair<Int, Int>> { it.first }
            .thenBy { it.second }
    )
    val pointsSorted = points.sorted()


    val result = mutableMapOf<Int, Int>()
    var startIndex = 0
    for (i in pointsSorted.indices) {
        var index = startIndex
        var counter = 0

        while (index < n && pointsSorted[i] >= segmentsSorted[index].first) {
            if (pointsSorted[i] >= segmentsSorted[index].first && pointsSorted[i] <= segmentsSorted[index].second) {
                if (counter == 0) startIndex = index
                counter++
            }

            index++
        }

        result[pointsSorted[i]] = counter
    }

    val sb = StringBuilder()
    points.forEachIndexed { index, item ->
        if (index > 0) sb.append(' ')
        sb.append(result[item])
    }
    println(sb.toString())
}