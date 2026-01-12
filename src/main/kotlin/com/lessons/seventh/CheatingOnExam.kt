package com.lessons.seventh


fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val checkingDesks = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (b, e) = readLine()!!.trim().split(" ").map { it.toInt() }
        checkingDesks.add(b to e)
    }

    val result = determinateNumberOfStudentsWithoutSupervision(n, checkingDesks)
    println(result)
}


fun determinateNumberOfStudentsWithoutSupervision(numberOfDesks: Int, checkingDesks: List<Pair<Int, Int>>) : Int {

    val checkingDesksSet = mutableSetOf<Int>()

    for (item in checkingDesks) {
        for (i in item.first..item.second) {
            checkingDesksSet.add(i)
        }
    }

    return numberOfDesks - checkingDesksSet.size
}