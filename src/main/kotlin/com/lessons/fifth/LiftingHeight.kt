package com.lessons.fifth



/*
Время = 0.66s
Память = 43.97Mb

Сложность = O(2 * N + M) = O(N + M)
 */
fun main() {

    val n = readLine()!!.trim().toInt()
    val coords = mutableListOf<Pair<Int, Int>>()
    // O(N)
    repeat(n) {
        val (x, y) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val m = readLine()!!.trim().toInt()
    val tracks = mutableListOf<Pair<Int, Int>>()
    // O(M)
    repeat(m) {
        val (s, f) = readLine()!!.trim().split(' ').map { it.toInt() }
        tracks.add(s to f)
    }

    val result = determinateTracksLiftingHeights(coords, tracks)
    println(result)
}



fun determinateTracksLiftingHeights(coords: List<Pair<Int, Int>>, tracks: List<Pair<Int, Int>>) : String {

    val result = mutableListOf<String>()

    val sumHeights = initializeStraightSumLiftingHeights(coords)
    val sumHeightsReverse = initializeReverseSumLiftingHeights(coords)

    // O(M)
    // Расчет суммарной высоты подъемов каждого пути
    for (i in tracks) {
        val sumHeightsTrack = calculateSumLiftingHeights(i.first, i.second, sumHeights, sumHeightsReverse)
        result.add(sumHeightsTrack.toString())
    }

    return result.joinToString("\n")
}



/**
 * Инициализация префикс-суммы для высоты подъема при прямом ходе
 */
fun initializeStraightSumLiftingHeights(coords: List<Pair<Int, Int>>) : IntArray {

    val sumHeights = IntArray(coords.size)

    // Определение высот подъема
    sumHeights[0] = 0
    for (i in 1..sumHeights.lastIndex) {    // O(N)

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



/**
 * Инициализация префикс-суммы для высоты подъема при обратном ходе
 */
fun initializeReverseSumLiftingHeights(coords: List<Pair<Int, Int>>) : IntArray {

    val sumHeights = IntArray(coords.size)

    // Определение высот подъема
    sumHeights[sumHeights.lastIndex] = 0
    for (i in (sumHeights.lastIndex - 1) downTo 0) {    // O(N)

        if (coords[i].second > coords[i + 1].second) {
            // Подъем
            sumHeights[i] = sumHeights[i + 1] + (coords[i].second - coords[i + 1].second)

        } else {
            // Спуск
            sumHeights[i] = sumHeights[i + 1]
        }
    }

    return sumHeights
}



/**
 * Расчет суммарной высоты подъемов на данной трассе
 */
fun calculateSumLiftingHeights(start: Int, finish: Int, sumHeights: IntArray, sumHeightsReverse: IntArray) : Int {

    var sum = 0

    if (start < finish) {
        sum = sumHeights[finish - 1] - sumHeights[start - 1]

    } else if (start == finish) {
        sum = 0

    } else {
        sum = sumHeightsReverse[finish - 1] - sumHeightsReverse[start - 1]
    }

    return sum
}