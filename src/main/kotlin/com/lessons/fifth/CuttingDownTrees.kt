package com.lessons.fifth


fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val treesVarieties = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinLengthSegment(treesVarieties, k)
    println("${result.first} ${result.second}")
}


fun determinateMinLengthSegment(treesVariety: List<Int>, numberOfVarieties: Int) : Pair<Int, Int> {

    // Массив флагов вхождения в диапазон
    val flagsVarieties = BooleanArray(treesVariety.size)

    // Количество сортов на отрезке
    var counterVarieties = 0

    // Определение количества сортов на отрезке
    for (i in 0 until numberOfVarieties) {

        val currentVariety = treesVariety[i] - 1

        // Нет сорта на отрезке
        if (!flagsVarieties[currentVariety]) {

            flagsVarieties[currentVariety] = true
            counterVarieties++
        }
    }

    var start = 0
    var finish = treesVariety.lastIndex

    return start to finish
}