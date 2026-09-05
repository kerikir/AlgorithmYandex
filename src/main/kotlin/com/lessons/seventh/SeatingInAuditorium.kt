package com.lessons.seventh

/*
Время = 389ms
Память = 24.17Mb

Сложность = O(N*logN)
 */
fun main() {
    val (n, d) = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }
    val coords = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }

    val coordsSorted = coords.sorted()

    var maxLength = 1
    var right = 1
    for (left in coords.indices) {
        var length = right - left

        while (right < n && coordsSorted[right] - coordsSorted[left] <= d) {
            right++
            length++
        }

        if (length > maxLength) {
            maxLength = length
        }
    }

    val result = mutableMapOf<Int, Int>()
    coordsSorted.forEachIndexed { index, item ->
        result[item] = index % maxLength + 1
    }

    val sb = StringBuilder()
    sb.append(maxLength).append('\n')
    coords.forEachIndexed { index, item ->
        if (index > 0) sb.append(' ')
        sb.append(result[item])
    }
    println(sb.toString())
}