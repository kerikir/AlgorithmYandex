package com.lessons.second


/*
Время = 173ms
Память = 14.70Mb

Сложность = O(N)
 */
fun main() {
    val array = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = counterNumbersHigherThanNeighbors(array)
    println(result)
}


fun counterNumbersHigherThanNeighbors(list: List<Int>) : Int {
    var counter = 0

    if (list.isNullOrEmpty() || list.size <= 2) return 0

    for (i in 1..list.lastIndex - 1) {
        if (list[i - 1] < list[i] && list[i] > list[i + 1]) {
            counter++
        }
    }

    return counter
}