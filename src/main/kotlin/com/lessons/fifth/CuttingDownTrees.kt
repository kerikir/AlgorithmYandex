package com.lessons.fifth


fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val treesVariety = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinLengthSegment(treesVariety, k)
    println("${result.first} ${result.second}")
}


fun determinateMinLengthSegment(treesVariety: List<Int>, numberOfVariety: Int) : Pair<Int, Int> {

    var start = 0
    var finish = treesVariety.lastIndex

    return start to finish
}