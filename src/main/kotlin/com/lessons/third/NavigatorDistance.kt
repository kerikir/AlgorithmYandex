package com.lessons.third

import kotlin.math.max
import kotlin.math.min


/*
Время = 461ms
Память = 22.56Mb

Сложность = O(N + A * B)
 */
fun main() {
    val (t, d, n) = readLine()!!.trim().split(" ").map { it.toInt() }

    // O(N)
    val coords = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (x, y) = readLine()!!.trim().split(" ").map { it.toInt() }
        coords.add(x to y)
    }

    val result = calculateDistance(t, n, d, coords)
    println(result.size)
    result.forEach {
        println("${it.first} ${it.second}")
    }
}



fun calculateDistance(time: Int, numberOfMeasurements: Int, accuracy: Int, coords: List<Pair<Int, Int>>)
: Set<Pair<Int, Int>> {

    var position = IntArray(4) { 0 }

    // O(N)
    // Симуляция перемещения
    for (i in 1..numberOfMeasurements) {

        position = definitionPossiblePosition(position, time)

        val positionNavigator = definitionPositionOnNavigator(coords[i - 1], accuracy)

        position = definitionPosition(position, positionNavigator)
    }

    val possiblePosition = mutableSetOf<Pair<Int, Int>>()

    // O(A * B)
    // Определение координат
    for (firstDiagonal in position[0]..position[1]) {
        for (secondDiagonal in position[2]..position[3]) {
            if ((firstDiagonal + secondDiagonal) % 2 == 0) {
                val x = (firstDiagonal + secondDiagonal) / 2
                val y = firstDiagonal - x
                possiblePosition.add(x to y)
            }
        }
    }

    return possiblePosition
}



/**
 * Определение позиции по показаниям навигатора
 *
 * @param coords Показание навигатора
 * @param accuracy Точность навигатора
 * @return Возможный район местоположения по навигатору `[qMin, qMax, pMin, pMax]`
 */
fun definitionPositionOnNavigator(coords: Pair<Int, Int>, accuracy: Int) : IntArray {

    // x + y = q (X)
    val diagonalFirstMin = (coords.first + coords.second) - accuracy
    val diagonalFirstMax = (coords.first + coords.second) + accuracy

    // x - y = p (Y)
    val diagonalSecondMin = (coords.first - coords.second) - accuracy
    val diagonalSecondMax = (coords.first - coords.second) + accuracy

    return intArrayOf(diagonalFirstMin, diagonalFirstMax, diagonalSecondMin, diagonalSecondMax)
}



/**
 * Определение возможной позиции
 *
 *  @param possiblePosition Позиция старта `[qMin, qMax, pMin, pMax]`
 *  @param time Время в пути
 *  @return Возможная позиция при ходьбе `[qMin, qMax, pMin, pMax]`
 */
fun definitionPossiblePosition(possiblePosition: IntArray, time: Int) : IntArray {

    // x + y = q (X)
    val diagonalFirstMin = possiblePosition[0] - time
    val diagonalFirstMax = possiblePosition[1] + time

    // x - y = p (Y)
    val diagonalSecondMin = possiblePosition[2] - time
    val diagonalSecondMax = possiblePosition[3] + time

    return intArrayOf(diagonalFirstMin, diagonalFirstMax, diagonalSecondMin, diagonalSecondMax)
}



/**
 * Корректирование позиции по навигатору
 *
 * @param possiblePosition Возможная позиция `[qMin, qMax, pMin, pMax]`
 * @param navigatorPosition Показание навигатора `[qMin, qMax, pMin, pMax]`
 * @return Скорректированная позиция `[qMin, qMax, pMin, pMax]`
 */
fun definitionPosition(possiblePosition: IntArray, navigatorPosition: IntArray) : IntArray {

    // x + y = q (X)
    val diagonalFirstMin = max(possiblePosition[0], navigatorPosition[0])
    val diagonalFirstMax = min(possiblePosition[1], navigatorPosition[1])

    // x - y = p (Y)
    val diagonalSecondMin = max(possiblePosition[2], navigatorPosition[2])
    val diagonalSecondMax = min(possiblePosition[3], navigatorPosition[3])

    return intArrayOf(diagonalFirstMin, diagonalFirstMax, diagonalSecondMin, diagonalSecondMax)
}