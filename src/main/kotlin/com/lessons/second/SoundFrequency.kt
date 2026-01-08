package com.lessons.second

import kotlin.math.abs
import kotlin.math.max
import kotlin.math.min
import kotlin.math.pow



/*
Время = 266ms
Память = 18.95Mb
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

    var leftBorder = 30.0f
    var rightBorder = 4000.0f

    val eps = 10.0.pow(-5)

    for (i in 1..measurements.lastIndex) {

        if (measurements[i].first - measurements[i - 1].first < eps) {

            if (measurements[i].second == "closer") {
                rightBorder = min(rightBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            } else {
                leftBorder = max(leftBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            }

        } else if (measurements[i].first - measurements[i - 1].first > eps) {

            if (measurements[i].second == "closer") {
                leftBorder = max(leftBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            } else {
                rightBorder = min(rightBorder, abs(measurements[i].first + measurements[i - 1].first) / 2.0f)
            }
        }
    }

    return "$leftBorder $rightBorder"
}