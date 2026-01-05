package com.lessons.second

import kotlin.math.max
import kotlin.math.min


fun main() {
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = largestMultiplicationTwoNumbers(numbers)
    println("${result.first} ${result.second}")
}


fun largestMultiplicationTwoNumbers(list: List<Int>) : Pair<Int, Int> {
    var min1 = min(list[0], list[1])
    var min2 = max(list[0], list[1])
    var max1 = min2
    var max2 = min1

    for (i in 2..list.lastIndex) {
        if (list[i] > max1) {
            max2 = max1
            max1 = list[i]
        } else if (list[i] > max2) {
            max2 = list[i]
        }

        if (list[i] < min1) {
            min2 = min1
            min1 = list[i]
        } else if (list[i] < min2) {
            min2 = list[i]
        }
    }

    val multiplicationMinNumbers = min1 * min2
    val multiplicationMaxNumbers = max2 * max1

    if (multiplicationMinNumbers > multiplicationMaxNumbers) {
        return Pair(min1, min2)
    } else {
        return Pair(max2, max1)
    }
}