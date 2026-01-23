package com.lessons.fifth


fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val treesVariety = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinLengthSegment(treesVariety, k)
    println("${result.first} ${result.second}")
}


fun determinateMinLengthSegment(treesVariety: List<Int>, numberOfVariety: Int) : Pair<Int, Int> {

    // Массив флагов вхождения в диапазон
    val flagsVariety = BooleanArray(treesVariety.size)

    // Количество сортов на отрезке
    var counterVariety = 0

    // Определение количества сортов на отрезке
    for (i in 0 until numberOfVariety) {

        val currentVariety = treesVariety[i] - 1

        // Нет сорта на отрезке
        if (!flagsVariety[currentVariety]) {

            flagsVariety[currentVariety] = true
            counterVariety++
        }
    }

    var start = 0
    var finish = treesVariety.lastIndex

    return start to finish
}