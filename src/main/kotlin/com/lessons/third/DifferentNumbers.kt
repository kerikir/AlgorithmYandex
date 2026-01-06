package com.lessons.third


/*
Время = 457ms
Память = 31.66Mb
 */
fun main() {
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }
    val result = numberOfDifferentNumbers(numbers)
    println(result)
}


fun numberOfDifferentNumbers(list: List<Int>) : Int {
    val set = list.toSet()
    return set.size
}