package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val x = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateVariationsOfGameScore(x, k)
    println(result)
}



fun determinateVariationsOfGameScore(cards: List<Int>, maxDiff: Int) : Long {

    var counter = 0L

    return counter
}