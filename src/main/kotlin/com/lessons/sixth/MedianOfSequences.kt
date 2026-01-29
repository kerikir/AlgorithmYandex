package com.lessons.sixth

import kotlin.math.max
import kotlin.math.min



/*
Время =
Память =
 */
fun main() {

    val (n, l) = readLine()!!.trim().split(' ').map { it.toInt() }

    val sequences = mutableListOf<IntArray>()
    repeat(n) {
        val sequence = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
        sequences.add(sequence)
    }

    // Перебор всех пар последовательностей
    for (i in 0 until sequences.lastIndex - 1) {
        for (j in (i + 1)..sequences.lastIndex) {
            println(determinateLeftMedianOfSequences(sequences[i], sequences[j], l))
        }
    }
}



fun determinateLeftMedianOfSequences(sequenceFirst: IntArray, sequenceSecond: IntArray, median: Int) : Int {

    // Определение границ значения медианы
    var leftBorder = min(sequenceFirst[0], sequenceSecond[0])
    var rightBorder = max(sequenceFirst[sequenceFirst.lastIndex], sequenceSecond[sequenceSecond.lastIndex])

    while (leftBorder < rightBorder) {

        val middle = (leftBorder + rightBorder) / 2

        if (true) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun determinateNumberOfLessNumbers(value: Int, sequence: IntArray) : Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    // Определение наибольшего индеса элемента, который меньше значения
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1) / 2

        if (sequence[middle] < value) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }

    return leftBorder + 1
}