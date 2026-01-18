package com.lessons.third


fun main() {
    val (t, d, n) = readLine()!!.trim().split(" ").map { it.toInt() }

    val coords = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (x, y) = readLine()!!.trim().split(" ").map { it.toInt() }
        coords.add(x to y)
    }

    val result = calculateDistance(t, n, d, coords)
    println(result.size)
    result.forEach {
        println("${it.first} ${it.second}")
    }
}


fun calculateDistance(time: Int, numberOfMeasurements: Int, accuracy: Int, coords: List<Pair<Int, Int>>)
: List<Pair<Int, Int>> {

}


/**
 * Определение возможной позиции по показаниям навигатора
 *
 * @return `[pMin, pMax, qMin, qMax]`
 */
fun definitionPosition(coords: Pair<Int, Int>, accuracy: Int) : IntArray {

    // x - y = p
    val diagonalFirstMin = (coords.first - coords.second) - accuracy
    val diagonalFirstMax = (coords.first - coords.second) + accuracy

    // x + y = q
    val diagonalSecondMin = (coords.first + coords.second) - accuracy
    val diagonalSecondMax = (coords.first + coords.second) + accuracy

    return intArrayOf(diagonalFirstMin, diagonalFirstMax, diagonalSecondMin, diagonalSecondMax)
}