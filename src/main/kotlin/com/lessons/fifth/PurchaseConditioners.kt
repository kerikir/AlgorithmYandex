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

    val result = calculateCostConditioners(a, infoAboutConditioners)
    println(result)
}



fun calculateCostConditioners(
    requirementOfClasses: List<Int>, infoAboutConditioners: List<Pair<Int, Int>>
) : Int {

    // Сортировка классов по требованиям к кондиционеру
    val sortedClasses = requirementOfClasses.sorted()

    // Сортировка кондиционеров по стоимости
    val sortedConditioners = infoAboutConditioners.sortedBy { it.second }

    var sumCost = 0

    return sumCost
}