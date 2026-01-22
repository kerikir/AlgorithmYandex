package com.lessons.fifth



fun main() {

    val n = readLine()!!.trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val m = readLine()!!.trim().toInt()
    val tracks = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (s, f) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(s to f)
    }
}



fun determinateTracksLiftingHeights(coords: List<Pair<Int, Int>>, tracks: List<Pair<Int, Int>>) : String {

    val result = mutableListOf<String>()

    return result.joinToString("\n")
}



/**
 * Инициализация префикс-суммы для высоты подъема при прямом ходе
 */
fun initializeStraightSumLiftingHeights(coords: List<Pair<Int, Int>>) : IntArray {

    val sumHeights = IntArray(coords.size)

    // Определение высот подъема
    sumHeights[0] = 0
    for (i in 1..sumHeights.lastIndex) {

        if (coords[i].second > coords[i - 1].second) {
            // Подъем
            sumHeights[i] = sumHeights[i - 1] + (coords[i].second - coords[i - 1].second)

        } else {
            // Спуск
            sumHeights[i] = sumHeights[i - 1]
        }
    }

    return sumHeights
}