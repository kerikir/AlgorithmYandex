package com.lessons.second


/*
Время = 0.557s
Память = 30.59Mb

Сложность = O(2*N) = O(N)
 */
fun main() {
    val n = readLine()!!.trim().toInt()
    val throwingRangeList = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = definitionPlaceInChampionship(throwingRangeList)
    println(result)
}


fun definitionPlaceInChampionship(list: List<Int>) : Int {
    var max = list[0]
    var index = -1

    // Поиск участника в списке бросков
    for (i in 1..list.lastIndex) {
        if (list[i] > max) {
            // Определение максимума
            max = list[i]
            index = -1
        } else if (
            (list[i] % 5 == 0) && (i != list.lastIndex) &&
            (list[i] > list[i + 1]) && list[i].toString().endsWith('5')
        ) {
            if (index == -1) {
                // Первое подходящее
                index = i
            } else if (list[i] > list[index]) {
                // Наибольшее из подходящих
                index = i
            }
        }
    }

    // Подсчет места участника
    var placement: Int
    if (index > 0) {
        placement = 1

        for (i in list.indices) {
            if (list[i] > list[index]) {
                placement++
            }
        }
    } else {
        placement = 0
    }

    return placement
}