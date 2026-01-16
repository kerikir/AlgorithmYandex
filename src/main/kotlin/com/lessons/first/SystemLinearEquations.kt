package com.lessons.first

import kotlin.math.abs
import kotlin.math.pow


/*
Нет решение - неверный ответ (25 проверка)
 */
fun main() {
    val a = readLine()!!.trim().toFloat()
    val b = readLine()!!.trim().toFloat()
    val c = readLine()!!.trim().toFloat()
    val d = readLine()!!.trim().toFloat()
    val e = readLine()!!.trim().toFloat()
    val f = readLine()!!.trim().toFloat()


    val result = calculateLinearEquation(a, b, c, d, e, f)
    println(result)
}



/**
 * ax + by = e
 *
 * cx + dy = f
 */
fun calculateLinearEquation(a: Float, b: Float, c: Float, d: Float, e: Float, f: Float)
: String {

    // Поиск определителя
    val determinant = a * d - c * b

    // Вырожденные случаи
    if (equalsZero(determinant)) {

        // Все коэффициенты нулевые
        if (equalsZero(a) && equalsZero(b) && equalsZero(c) && equalsZero(d)) {

            if (equalsZero(e) && equalsZero(f)) {
                // Любая пара - решение
                return "5"
            } else {
                // Нет решения - противоречие
                return "0"
            }

        } else if (equalsZero(a) && equalsZero(b) && equalsZero(e)) {
            // Одна строка пустая - 0x + 0y = 0
            return calculateSingleEquation(c, d, f)

        } else if (equalsZero(c) && equalsZero(d) && equalsZero(f)) {
            // Одна строка пустая - 0x + 0y = 0
            return calculateSingleEquation(a, b, e)

        } else {

            if (equalsZero(c)) {
                // Пропорциональные строки
                return calculateSingleEquation(c, d, f)

            } else if (equalsZero(d)) {
                // Пропорциональные строки
                return calculateSingleEquation(c, d, f)

            } else if (
                equalsZero(b) && equalsZero(d) && equalsZero(a * f - e * c) ||
                equalsZero(a) && equalsZero(c) && equalsZero(b * f - e * d) ||
                equalsZero(a * f - e * c) && equalsZero(b * f - e * d)
                ) {
                // Убрано деление на 0 с помощью умножения
                // Пропорциональные строки
                return calculateSingleEquation(c, d, f)

            } else {
                // Нет решения
                return "0"
            }
        }

    } else {

        val pairResult = calculateCramerRule(a, b, c, d, e, f, determinant)
        return "2 ${pairResult.first} ${pairResult.second}"
    }

    return "0"
}



fun calculateCramerRule(a: Float, b: Float, c: Float, d: Float, e: Float, f: Float, determinant: Float)
: Pair<Float, Float> {

    val determinant1 = e * d - f * b
    val determinant2 = a * f - c * e

    val x = determinant1 / determinant
    val y = determinant2 / determinant

    return x to y
}



fun calculateSingleEquation(c: Float, d: Float, f: Float) : String {

    if (equalsZero(d)) {
        // Много решений (y - любое) - x = x0
        val x = f / c
        return "3 $x"
    } else if (equalsZero(c)) {
        // Много решений (x - любое) - y = y0
        val y = f / d
        return "4 $y"
    } else {
        // Много решений - y = kx + z
        val k = -c / d
        val z = f / d
        return "1 $k $z"
    }
}



fun equalsZero(value: Float) : Boolean {
    val eps = 10.0f.pow(-6)
    return abs(value) < eps
}