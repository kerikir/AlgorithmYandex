package com.lessons.second


/*
Время = 477ms
Память = 29.70Mb
 */
fun main() {
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = largestMultiplicationThreeNumbers(numbers)
    println("${result.first} ${result.second} ${result.third}")
}


fun largestMultiplicationThreeNumbers(list: List<Int>) : Triple<Int, Int, Int> {
    var min1 = Int.MAX_VALUE
    var min2 = Int.MAX_VALUE
    var max1 = Int.MIN_VALUE
    var max2 = Int.MIN_VALUE
    var max3 = Int.MIN_VALUE

    for (i in list.indices) {
        // Находим максимальные числа в последовательности
        if (list[i] > max1) {
            max3 = max2
            max2 = max1
            max1 = list[i]
        } else if (list[i] > max2) {
            max3 = max2
            max2 = list[i]
        } else if (list[i] > max3) {
            max3 = list[i]
        }

        // Находим минимальные числа в последовательности
        if (list[i] < min1) {
            min2 = min1
            min1 = list[i]
        } else if (list[i] < min2) {
            min2 = list[i]
        }
    }

    // Решение проблемы с переполнениме
    val multiplicationMinNumbers: Long = min1 * min2 * max1.toLong()
    val multiplicationMaxNumbers: Long = max3 * max2 * max1.toLong()

    return if (multiplicationMinNumbers >= multiplicationMaxNumbers) {
        Triple(min1, min2, max1)
    } else {
        Triple(max3, max2, max1)
    }
}