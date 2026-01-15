package com.lessons.second

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow



/*
Время = 266ms
Память = 18.95Mb

Сложность = O(N)
 */
fun main() {
    val n = readLine()!!.trim().toInt()

    val measurements = mutableListOf<Pair<Float, String>>()
    val freq = readLine()!!.trim().toFloat()

    measurements.add(freq to "")
    for (i in 2..n) {
        val (freq, ans) = readLine()!!.trim().split(" ")
        measurements.add(freq.toFloat() to ans)
    }

    val result = definitionSoundFrequency(measurements)
    println(result)
}



fun definitionSoundFrequency(measurements: List<Pair<Float, String>>) : String {

    // Границы диапазона
    var leftBorder = 30.0f
    var rightBorder = 4000.0f

    // Точность измерений
    val eps = 10.0.pow(-5)

    for (i in 1..measurements.lastIndex) {

        if (measurements[i].first - measurements[i - 1].first < eps) {

            if (measurements[i].second == "closer") {
                // Меньшая частота и ближе
                rightBorder = min(rightBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            } else {
                // Меньшая частота и дальше
                leftBorder = max(leftBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            }

        } else if (measurements[i].first - measurements[i - 1].first > eps) {

            if (measurements[i].second == "closer") {
                // Большая частота и ближе
                leftBorder = max(leftBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            } else {
                // Большая частота и дальше
                rightBorder = min(rightBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            }
        }
    }

    return "$leftBorder $rightBorder"
}