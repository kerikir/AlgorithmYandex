package com.lessons.sixth

import kotlin.math.max
import kotlin.math.min



/*
Время = 491ms
Память = 28.02Mb

Сложность = O(N^2 * logK * logL)
 */
fun main() {

    val (n, l) = readLine()!!.trim().split(' ').map { it.toInt() }

    val sequences = mutableListOf<IntArray>()
    repeat(n) {
        val sequence = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
        sequences.add(sequence)
    }

    // Перебор всех пар последовательностей
    for (i in 0 until sequences.lastIndex) {    // (N^2)
        for (j in (i + 1)..sequences.lastIndex) {
            println(determinateLeftMedianOfSequences(sequences[i], sequences[j], l))
        }
    }
}



fun determinateLeftMedianOfSequences(sequenceFirst: IntArray, sequenceSecond: IntArray, median: Int) : Int {

    // Определение границ значения медианы
    var leftBorder = min(sequenceFirst[0], sequenceSecond[0])
    var rightBorder = max(sequenceFirst[sequenceFirst.lastIndex], sequenceSecond[sequenceSecond.lastIndex])

    // O(logK)
    while (leftBorder < rightBorder) {

        val middle = (leftBorder + rightBorder) / 2

        // O(4*logL)
        val numberOfLessNumbers = determinateNumberOfLessNumbers(middle, sequenceFirst) +
                determinateNumberOfLessNumbers(middle, sequenceSecond)
        val numberOfHigherNumbers = determinateNumberOfHigherNumbers(middle, sequenceFirst) +
                determinateNumberOfHigherNumbers(middle, sequenceSecond)

        if ((numberOfLessNumbers <= median - 1) && (numberOfHigherNumbers <= median)) {
            // Определили медиану
            return middle
        } else if (numberOfLessNumbers >= median) {
            // Правее медианы
            rightBorder = middle - 1
        } else if (numberOfHigherNumbers >= median + 1) {
            // Левее медианы
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



/**
 * Левый бинарный поиск.
 * Определение количества элементов в последовательности, которые меньше числа.
 */
fun determinateNumberOfLessNumbers(value: Int, sequence: IntArray) : Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    // Определение наименьший индес из элементов, которые больше либо равны значению
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        // Обратный поиск
        if (sequence[middle] >= value) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    // Проверка краевого условия
    return if ((leftBorder == sequence.lastIndex) && (sequence[leftBorder] < value)) {
        leftBorder + 1
    } else {
        leftBorder
    }
}



/**
 * Левый бинарный поиск.
 * Определение количества элементов в последовательности, которые больше числа.
 */
fun determinateNumberOfHigherNumbers(value: Int, sequence: IntArray) : Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    // Определение наибольшего индеса из элементов, которые меньше либо равны значения
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1) / 2

        // Обратный поиск
        if (sequence[middle] <= value) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }

    // Проверка краевого условия
    return if ((leftBorder == 0) && (sequence[leftBorder] > value)) {
        sequence.size
    } else {
        sequence.lastIndex - leftBorder
    }
}