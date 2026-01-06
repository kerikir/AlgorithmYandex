package com.lessons.third

fun main() {
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }
    val result = numberOfDifferentNumbers(numbers)
    println(result)
}


fun numberOfDifferentNumbers(list: List<Int>) : Int {
    val set = list.toSet()
    return set.size
}