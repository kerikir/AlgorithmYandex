package com.lessons.first

import kotlin.math.max
import kotlin.math.min



/*
Время = 165ms
Память = 13.66Mb

Сложность = O(1)
 */
fun main() {
    val a = readLine()!!.trim().toInt()
    val b = readLine()!!.trim().toInt()
    val n = readLine()!!.trim().toInt()
    val m = readLine()!!.trim().toInt()

    val time = calculateTime(a, b, n, m)
    if (time.first == -1) {
        // Ответы не сходятся
        println("-1")
    } else {
        println("${time.first} ${time.second}")
    }
}



fun calculateTime(ia: Int, ib: Int, ka: Int, kb: Int, ta: Int = 1, tb: Int = 1) : Pair<Int,Int> {
    // Максимальное допустимое время ожидания каждого поезда
    val tmaxA = ia * (ka + 1) + ka * ta
    val tmaxB = ib * (kb + 1) + kb * tb

    // Минимальное допустимое время ожидания каждого поезда
    val tminA = ia * (ka - 1) + ka * ta
    val tminB = ib * (kb - 1) + kb * tb

    // Сходятся ли ответы
    if ((tminA > tmaxB) || (tminB > tmaxA)) {
        return -1 to -1
    }

    // Определение допустимого времени ожидания всех поездов
    val tmin = max(tminA, tminB)
    val tmax = min(tmaxA, tmaxB)

    return tmin to tmax
}