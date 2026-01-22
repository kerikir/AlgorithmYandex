package com.lessons.fifth



fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val carNumbers = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNumberOfSetCars(carNumbers, k)
    println(result)
}



fun determinateNumberOfSetCars(carNumbers: List<Int>, value: Int) : Int {

    var counter = 0

    return counter
}