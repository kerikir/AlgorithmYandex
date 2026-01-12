package com.lessons.seventh


fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val checkingDesks = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (b, e) = readLine()!!.trim().split(" ").map { it.toInt() }
        checkingDesks.add(b to e)
    }

    val result = determinateNumberOfStudentsWithoutSupervision(checkingDesks)
    println(result)
}


fun determinateNumberOfStudentsWithoutSupervision(checkingDesks: List<Pair<Int, Int>>) : Int {

    val sortCheckingDesks = checkingDesks.sortedBy { it.first }

    return checkingDesks.size
}