package com.lessons.sixth

import kotlin.math.min


/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.trim().toInt()
    val m = readLine()!!.trim().toInt()
    val t = readLine()!!.trim().toLong()


}



fun determinateWidthPathOfTiles(n: Int, m: Int, numberOfTiles: Long) : Int {

    var leftBorder = 0L
    // Максимальная ширина дорожки - отсутствие клумбы по центру
    var rightBorder = min(n, m) / 2L

    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1L) / 2L

        val isCorrect = true

        if (isCorrect) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1L
        }
    }
}