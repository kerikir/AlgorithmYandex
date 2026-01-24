package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.trim().toInt()

    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val result = determinateNumberOfTriangles(coords)
    println(result)
}



fun determinateNumberOfTriangles(coords: List<Pair<Int, Int>>) : Int {

    var counter = 0

    return counter
}