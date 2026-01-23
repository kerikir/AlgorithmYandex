package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.trim().toInt()
    val a = readLine()!!.trim().split(' ').map { it.toInt() }

    val m = readLine()!!.trim().toInt()
    val infoAboutConditioners = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (b, c) = readLine()!!.trim().split(' ').map { it.toInt() }
        infoAboutConditioners.add(b to c)
    }
}



fun calculateCostConditioners(
    requirementOfClasses: List<Int>, infoAboutConditioners: List<Pair<Int, Int>>
) : Int {

    var sumCost = 0

    return sumCost
}