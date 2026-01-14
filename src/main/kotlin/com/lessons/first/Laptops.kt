package com.lessons.first

import kotlin.math.max



/*
Время = 189ms
Память = 17.68Mb

Сложность = O(1)
 */
fun main() {
    val (length1, width1, length2, width2) = readLine()!!.trim().split(" ").map { it.toInt() }

    val size = calculateTableSize(length1, width1, length2, width2)
    println("${size.first} ${size.second}")
}



fun calculateTableSize(length1: Int, width1: Int, length2: Int, width2: Int) : Pair<Int, Int> {

    val laptop1 = listOf(length1, width1)
    val laptop2 = listOf(length2, width2)

    var minArea = Int.MAX_VALUE
    var currentArea: Int

    var length = 0
    var width = 0

    // Перебор размеров стола
    for (i in laptop1.indices) {
        for (j in laptop2.indices) {
            val index1 = (i + 1) % laptop1.size
            val index2 = (j + 1) % laptop2.size

            // Определение площади
            currentArea = calculateArea(laptop1[i], laptop2[j], laptop1[index1], laptop2[index2])

            // Определение минимальной площади
            if (currentArea < minArea) {
                minArea = currentArea
                length = laptop1[i] + laptop2[j]
                width = max(laptop1[index1], laptop2[index2])
            }
        }
    }

    return length to width
}



fun calculateArea(sum1: Int, sum2: Int, max1: Int, max2: Int) : Int {
    // Определение площади стола
    return (sum1 + sum2) * max(max1, max2)
}