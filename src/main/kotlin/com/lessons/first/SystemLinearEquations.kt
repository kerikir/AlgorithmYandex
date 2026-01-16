package com.lessons.first



/*
Нет решение - не понял задачу
 */
fun main() {
    val a = readLine()!!.trim().toFloat()
    val b = readLine()!!.trim().toFloat()
    val c = readLine()!!.trim().toFloat()
    val d = readLine()!!.trim().toFloat()
    val e = readLine()!!.trim().toFloat()
    val f = readLine()!!.trim().toFloat()


    val result = calculateLinearEquation(a, b, c, d, e, f)
    println("${result.first} ${result.second} ${result.third}")
}



/**
 * ax + by = e
 * 
 * cx + dy = f
 */
fun calculateLinearEquation(a: Float, b: Float, c: Float, d: Float, e: Float, f: Float)
: Triple<Float, Float, Float> {

    // Поиск определителя
    val determinant = a * d - c * b

    val determinant1 = c1 * b2 - c2 * b1
    val determinant2 = a1 * c2 - a2 * c1

    val x = determinant1 / determinant.toDouble()
    val y = determinant2 / determinant.toDouble()

    return x to y
}