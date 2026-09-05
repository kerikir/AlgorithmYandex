package com.lessons.seventh

import kotlin.math.max
import kotlin.math.min


/*
Время = 1.862s
Память = 64.57Mb

Сложность = O((N + M) * log(N + M))
 */
fun main() {
    val (n, m) = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }
    val segments = ArrayList<Pair<Int, Int>>(n)
    for (i in 0..n - 1) {
        val (a, b) = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }
        segments.add(min(a, b) to max(a, b))
    }
    val points = readLine()!!.trim().split(Regex("\\s+")).map { it.toInt() }

    val events = ArrayList<Pair<Int, Event>>(2 * n + m)
    segments.forEach { pair ->
        events.add(pair.first to Event.START)
        events.add(pair.second to Event.END)
    }
    points.forEach { x ->
        events.add(x to Event.POINT)
    }

    val eventsSorted = events.sortedWith(
        compareBy<Pair<Int, Event>> { it.first }
            .thenBy { it.second }
    )

    var counterSegments = 0
    val result = mutableMapOf<Int, Int>()
    eventsSorted.forEach { event ->
        when (event.second) {
            Event.START -> {
                counterSegments++
            }
            Event.POINT -> {
                result[event.first] = counterSegments
            }
            Event.END -> {
                counterSegments--
            }
        }
    }

    val sb = StringBuilder()
    points.forEachIndexed { index, item ->
        if (index > 0) sb.append(' ')
        sb.append(result[item])
    }
    println(sb.toString())
}


enum class Event {
    START, POINT, END
}