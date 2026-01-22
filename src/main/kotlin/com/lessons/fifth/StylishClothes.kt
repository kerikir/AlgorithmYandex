package com.lessons.fifth



fun main() {

    val n = readLine()!!.trim().toInt()
    val colorsTShirt = readLine()!!.trim().split(' ').map { it.toInt() }

    val m = readLine()!!.trim().toInt()
    val colorsPants = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateColorsOfTShirtAndPants(colorsTShirt, colorsPants)
    println("${result.first} ${result.second}")
}



fun determinateColorsOfTShirtAndPants(colorsTShirt: List<Int>, colorsPants: List<Int>) : Pair<Int, Int> {

    return colorsTShirt[0] to colorsPants[0]
}