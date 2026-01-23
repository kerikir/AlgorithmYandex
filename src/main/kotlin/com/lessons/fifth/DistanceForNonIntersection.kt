package com.lessons.fifth



fun main() {

    val (n, r) = readLine()!!.trim().split(' ').map { it.toInt() }
    val d = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNumberOfOptionForNonIntersection(d, r)
    println(result)
}



fun determinateNumberOfOptionForNonIntersection(
    distanceBetweenMonuments: List<Int>, visibilityDistance: Int
) : Int {

    var counter = 0



    return counter
}