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
: String {

    var result = ""

    // Поиск определителя
    val determinant = a * d - c * b

    if (!determinant.equals(0.0f)) {

        val pairResult = calculateCramerRule(a, b, c, d, e, f, determinant)
        result = "2 ${pairResult.first} ${pairResult.second}"

    } else {
        // Все коэффициенты нулевые
        if (a.equals(0.0f) && b.equals(0.0f) && c.equals(0.0f) && d.equals(0.0f)) {

            if (e.equals(0.0f) && f.equals(0.0f)) {
                // Любая пара - решение
                result = "5"
            } else {
                // Нет решения - противоречие
                result = "0"
            }
        }
        else if ()
    }

    return result
}



fun calculateCramerRule(a: Float, b: Float, c: Float, d: Float, e: Float, f: Float, determinant: Float)
: Pair<Float, Float> {

    val determinant1 = e * d - f * b
    val determinant2 = a * f - c * e

    val x = determinant1 / determinant
    val y = determinant2 / determinant

    return x to y
}