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
    for (i in 0 until sequences.lastIndex) {
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

        val numberOfLessNumbers = determinateNumberOfLessNumbers(middle, sequenceFirst) +
                determinateNumberOfLessNumbers(middle, sequenceSecond)
        val numberOfHigherNumbers = determinateNumberOfHigherNumbers(middle, sequenceFirst) +
                determinateNumberOfHigherNumbers(middle, sequenceSecond)

        if ((numberOfLessNumbers <= median - 1) && (numberOfHigherNumbers <= median)) {
            return middle
        } else if (numberOfLessNumbers >= median) {
            rightBorder = middle - 1
        } else if (numberOfHigherNumbers >= median + 1) {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun determinateNumberOfLessNumbers(value: Int, sequence: IntArray) : Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    // Определение наименьший индес из элементов, которые больше либо равны значению
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        if (sequence[middle] >= value) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun determinateNumberOfHigherNumbers(value: Int, sequence: IntArray) : Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    // Определение наименьшего индеса из элементов, которые больше значения
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        if (sequence[middle] > value) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return sequence.size - leftBorder
}