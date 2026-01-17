package com.lessons.third


/*
Время = 457ms
Память = 31.66Mb

Сложность = O(N)
 */
fun main() {
    // O(N)
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = numberOfDifferentNumbers(numbers)
    println(result)
}


fun numberOfDifferentNumbers(list: List<Int>) : Int {
    // O(N)
    val set = list.toSet()
    // O(1)
    return set.size
}