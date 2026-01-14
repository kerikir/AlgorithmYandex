package com.lessons.first


/*
Время = 146ms
Память = 12.38Mb

Сложность = O(1)
 */
fun main() {
    val a = readLine()!!.toInt()
    val b = readLine()!!.toInt()
    val c = readLine()!!.toInt()

    val result = calculateEquation(a, b, c)
    println(result)
}


// O(1)
fun calculateEquation(a: Int, b: Int, c: Int) : String {
    // Область допустимых значений
    if (c < 0) return "NO SOLUTION"

    if (b == c * c) {
        return if (a == 0) "MANY SOLUTIONS" else "0"
    }

    if (a == 0) return "NO SOLUTION"

    val xDouble = (c * c - b) / a.toDouble()
    val xInt = (c * c - b) / a

    if ((a * xDouble + b) < 0) return "NO SOLUTION"

    if (xDouble == xInt.toDouble()) {
        return xInt.toString()
    } else {
        return "NO SOLUTION"
    }
}