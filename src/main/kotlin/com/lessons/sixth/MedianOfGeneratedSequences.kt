package com.lessons.sixth

import kotlin.math.max
import kotlin.math.min



/*
Время =
Память =

Сложность =
 */
fun main() {

    val (n, l) = readLine()!!.trim().split(' ').map { it.toInt() }

    val sequences = mutableListOf<IntArray>()
    repeat(n) {
        val (x1, d1, a, c, m) = readLine()!!.trim().split(' ').map { it.toInt() }
        val sequence = generateSequence(x1, d1, a, c, m, l)
        sequences.add(sequence)
    }

    // Перебор всех пар последовательностей
    for (i in 0 until sequences.lastIndex) {    // (N^2)
        for (j in (i + 1)..sequences.lastIndex) {
            println(LeftMedianOfSequences(sequences[i], sequences[j], l))
        }
    }
}



/**
 * Генерация последовательности для устранения медленного чтения данных из консоли
 */
fun generateSequence(x1: Int, d1: Int, a: Int, c: Int, m: Int, l: Int) : IntArray {

    // Инициализация последовательности начальными данными
    val x = IntArray(l)
    val d = IntArray(l)
    x[0] = x1
    d[0] = d1

    // Вычисление значения элементов последовательности
    for (i in 1..(l - 1)) {
        d[i] = (a * d[i - 1] + c) % m
        x[i] = x[i - 1] + d[i - 1]
    }

    return x
}



fun LeftMedianOfSequences(sequenceFirst: IntArray, sequenceSecond: IntArray, median: Int) : Int {

    // Определение границ значения медианы
    var leftBorder = min(sequenceFirst[0], sequenceSecond[0])
    var rightBorder = max(sequenceFirst[sequenceFirst.lastIndex], sequenceSecond[sequenceSecond.lastIndex])

    // O(logK)
    while (leftBorder < rightBorder) {

        val middle = (leftBorder + rightBorder) / 2

        // O(4*logL)
        val numberOfLessNumbers = NumberOfLessNumbers(middle, sequenceFirst) +
                NumberOfLessNumbers(middle, sequenceSecond)
        val numberOfHigherNumbers = NumberOfHigherNumbers(middle, sequenceFirst) +
                NumberOfHigherNumbers(middle, sequenceSecond)

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
fun NumberOfLessNumbers(value: Int, sequence: IntArray) : Int {

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
fun NumberOfHigherNumbers(value: Int, sequence: IntArray) : Int {

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