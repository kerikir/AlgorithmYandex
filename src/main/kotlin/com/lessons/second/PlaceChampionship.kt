package com.lessons.second


/*
Время = 173ms
Память = 14.70Mb
 */
fun main() {
    val n = readLine()!!.trim().toInt()
    val throwingRangeList = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = definitionPlaceInChampionship(throwingRangeList)
    println(result)
}


fun definitionPlaceInChampionship(list: List<Int>) : Int {
    var placement = 0
    var max = list[0]
    var index = -1

    // Поиск участника в списке бросков
    for (i in 1..list.lastIndex - 1) {
        if (list[i] > max) {
            max = list[i]
            index = -1
        } else if ((list[i] % 5 == 0) && (list[i + 1] < list[i]) && list[i].toString().endsWith('5')) {
            index = i
        }
    }

    // Подсчет места участника
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