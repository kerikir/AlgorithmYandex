package com.lessons.sixth

import kotlin.math.min



/*
Время = 166ms
Память = 13.74Mb

Сложность = O(logN)
 */
fun main() {

    val n = readLine()!!.trim().toLong()
    val m = readLine()!!.trim().toLong()
    val t = readLine()!!.trim().toLong()

    val result = determinateWidthPathOfTiles(n, m, t)
    println(result)
}



fun determinateWidthPathOfTiles(n: Long, m: Long, numberOfTiles: Long) : Long {

    var leftBorder = 0L
    // Максимальная ширина дорожки - отсутствие клумбы по центру
    var rightBorder = min(n, m) / 2L

    // O(log(min(N, M)))
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1L) / 2L

        val isCorrect = checkCorrectWidthPathOfTiles(middle, n, m, numberOfTiles)   // O(1)

        if (isCorrect) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1L
        }
    }

    return leftBorder
}



fun checkCorrectWidthPathOfTiles(width: Long, n: Long, m: Long, numberOfTiles: Long) : Boolean {

    // Потраченные плитки на определенную ширину для дорожки
    val numberOfTilesSpent = width * (2L * n + 2L * m) - 4L * width * width

    return numberOfTiles >= numberOfTilesSpent
}