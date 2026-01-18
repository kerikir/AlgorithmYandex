package com.lessons.third



fun main() {
    val (t, d, n) = readLine()!!.trim().split(" ").map { it.toInt() }

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

}



/**
 * Определение позиции по показаниям навигатора
 *
 * @param coords Показание навигатора
 * @param accuracy Точность навигатора
 * @return Возможный район местоположения по навигатору `[pMin, pMax, qMin, qMax]`
 */
fun definitionPositionOnNavigator(coords: Pair<Int, Int>, accuracy: Int) : IntArray {

    // x - y = p
    val diagonalFirstMin = (coords.first - coords.second) - accuracy
    val diagonalFirstMax = (coords.first - coords.second) + accuracy

    // x + y = q
    val diagonalSecondMin = (coords.first + coords.second) - accuracy
    val diagonalSecondMax = (coords.first + coords.second) + accuracy

    return intArrayOf(diagonalFirstMin, diagonalFirstMax, diagonalSecondMin, diagonalSecondMax)
}



/**
 * Определение возможной позиции
 *
 *  @param possiblePosition Позиция старта `[pMin, pMax, qMin, qMax]`
 *  @param time Время в пути
 *  @return Возможная позиция при ходьбе `[pMin, pMax, qMin, qMax]`
 */
fun definitionPossiblePosition(possiblePosition: IntArray, time: Int) : IntArray {


}



/**
 * Корректирование позиции по навигатору
 *
 * @param possiblePosition Возможная позиция `[pMin, pMax, qMin, qMax]`
 * @param navigatorPosition Показание навигатора `[pMin, pMax, qMin, qMax]`
 * @return Скорректированная позиция `[pMin, pMax, qMin, qMax]`
 */
fun definitionPosition(possiblePosition: IntArray, navigatorPosition: IntArray) : IntArray {

}