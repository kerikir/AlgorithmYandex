package com.lessons.fifth



fun main() {

    val n = readLine()!!.trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val m = readLine()!!.trim().toInt()
    val tracks = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (s, f) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(s to f)
    }
}



fun determinateTracksLiftingHeights(coords: List<Pair<Int, Int>>, tracks: List<Pair<Int, Int>>) : String {

    val result = mutableListOf<String>()

    return result.joinToString("\n")
}


