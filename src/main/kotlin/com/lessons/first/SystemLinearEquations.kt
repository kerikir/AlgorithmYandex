package com.lessons.first

fun main() {
    val a1 = readLine()!!.trim().toInt()
    val b1 = readLine()!!.trim().toInt()
    val c1 = readLine()!!.trim().toInt()
    val a2 = readLine()!!.trim().toInt()
    val b2 = readLine()!!.trim().toInt()
    val c2 = readLine()!!.trim().toInt()

    val result = calculateCramerRule(a1, b1, c1, a2, b2, c2)
    println("${result.first} ${result.second}")
}


fun calculateCramerRule(a1: Int, b1: Int, c1: Int, a2: Int, b2: Int, c2: Int) : Pair<Double,Double> {

    val determinant = a1 * b2 - a2 * b1

    val determinant1 = c1 * b2 - c2 * b1
    val determinant2 = a1 * c2 - a2 * c1

    val x = determinant1 / determinant.toDouble()
    val y = determinant2 / determinant.toDouble()

    return x to y
}