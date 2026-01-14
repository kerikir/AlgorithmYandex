package com.lessons.seventh


/*
Не решено - превышен лимит времени
Сложность = O(N*M) = O(N^2)
Память = O(M)
*/
fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val segments = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.trim().split(" ").map { it.toInt() }
        segments.add(a to b)
    }
    val points = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = determinateNumberOfPointsOnSegments(points, segments)
    println(result)
}


fun determinateNumberOfPointsOnSegments(points: List<Int>, segments: List<Pair<Int, Int>>) : String {

    val amountSegmentsList = mutableListOf<Int>()

    var amountSegments = 0

    for (point in points) {
        amountSegments = 0

        for (segment in segments) {
            if (point >= segment.first && point <= segment.second) {
                amountSegments++
            }
        }

        amountSegmentsList.add(amountSegments)
    }

    return amountSegmentsList.joinToString(" ")
}