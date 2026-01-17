package com.lessons.third


/*
Время = 238ms
Память = 17.27Mb

Сложность = O(N)
*/
fun main() {
    val n = readLine()!!.trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (x, y) = readLine()!!.trim().split(" ").map { it.toInt() }
        coords.add(x to y)
    }


    val result = determinateMinimumNumberOfShots(coords)
    println(result)
}


fun determinateMinimumNumberOfShots(coordsBirds: List<Pair<Int, Int>>) : Int {

    // O(2 * N)
    val shots = coordsBirds.map { it.first }.toSet()
    // O(1)
    return shots.size
}