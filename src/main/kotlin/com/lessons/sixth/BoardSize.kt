package com.lessons.sixth

import kotlin.math.min


fun main() {

    val (w, h, n) = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinBoardSize(n, h, w)
    println(result)
}


fun determinateMinBoardSize(numberOfDiplomas: Int, diplomaHeight: Int, diplomaWidth: Int) : Int {

    var maxBoardSize = numberOfDiplomas * min(diplomaHeight, diplomaWidth)

    val sizesOfBoard = IntArray(maxBoardSize) { it + 1 }

    for (size in sizesOfBoard) {

        val isCorrect = true

        if (isCorrect) {

            return size
        }
    }

    return maxBoardSize
}