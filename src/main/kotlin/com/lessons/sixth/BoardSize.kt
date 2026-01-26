package com.lessons.sixth

import kotlin.math.min


fun main() {

    val (w, h, n) = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinBoardSize(n, h, w)
    println(result)
}


fun determinateMinBoardSize(numberOfDiplomas: Int, diplomaHeight: Int, diplomaWidth: Int) : Int {

    var maxBoardSize = numberOfDiplomas * min(diplomaHeight, diplomaWidth)

    return maxBoardSize
}