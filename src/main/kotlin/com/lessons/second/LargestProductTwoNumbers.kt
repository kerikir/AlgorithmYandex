package com.lessons.second

import kotlin.math.max
import kotlin.math.min


/*
Время = 478ms
Память = 29.73Mb

Сложность = O(N)
 */
fun main() {
    // O(N)
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = largestMultiplicationTwoNumbers(numbers)
    println("${result.first} ${result.second}")
}


fun largestMultiplicationTwoNumbers(list: List<Int>) : Pair<Int, Int> {
    var min1 = min(list[0], list[1])
    var min2 = max(list[0], list[1])
    var max1 = min2
    var max2 = min1

    // O(N)
    for (i in 2..list.lastIndex) {
        // Находим максимальные числа в последовательности
        if (list[i] > max1) {
            max2 = max1
            max1 = list[i]
        } else if (list[i] > max2) {
            max2 = list[i]
        }

        // Находим минимальные числа в последовательности
        if (list[i] < min1) {
            min2 = min1
            min1 = list[i]
        } else if (list[i] < min2) {
            min2 = list[i]
        }
    }

    // O(1)
    // Решение проблемы с переполнениме
    val multiplicationMinNumbers: Long = min1 * min2.toLong()
    val multiplicationMaxNumbers: Long = max2 * max1.toLong()

    return if (multiplicationMinNumbers >= multiplicationMaxNumbers) {
        Pair(min1, min2)
    } else {
        Pair(max2, max1)
    }
}