package com.lessons.third


/*
Время = 331ms
Память = 23.79Mb

Сложность = O(2 * N) = O(N)
*/
fun main() {
    val n = readLine()!!.trim().toInt()
    val turtlesPlace = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.trim().split(" ").map { it.toInt() }
        turtlesPlace.add(a to b)
    }


    val result = determinateTurtleRacing(turtlesPlace, n)
    println(result)
}


fun determinateTurtleRacing(turtlesPlace: List<Pair<Int, Int>>, size: Int) : Int {

    // O(N)
    val possiblePlaces = mutableSetOf<Pair<Int, Int>>()
    for (i in 0..size - 1) {
        possiblePlaces.add(i to (size - 1 - i))
    }

    // O(N)
    val rightPlaces = turtlesPlace.intersect(possiblePlaces)
    // O(1)
    return rightPlaces.size
}