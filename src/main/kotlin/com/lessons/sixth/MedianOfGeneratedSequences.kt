package com.lessons.sixth

import kotlin.math.max
import kotlin.math.min



/*
Время = 1.559s
Память = 149.01Mb

Сложность = O(N * L + N^2 * logK * logL)
 */
fun main() {

    val (n, l) = readLine()!!.trim().split(' ').map { it.toInt() }

    val sequences = mutableListOf<LongArray>()
    // O(N * L)
    repeat(n) {
        // В контесте лишние пробелы
        val (x1, d1, a, c, m) = readLine()!!.trim().split(Regex("\\s+")).map { it.toLong() }
        val sequence = generateSequence(x1, d1, a, c, m, l)
        sequences.add(sequence)
    }

    // Перебор всех пар последовательностей
    for (i in 0 until sequences.lastIndex) {    // O(N^2)
        for (j in (i + 1)..sequences.lastIndex) {
            println(calculateLeftMedianOfSequences(sequences[i], sequences[j]))
        }
    }
}



/**
 * Генерация последовательности для устранения медленного чтения данных из консоли
 */
fun generateSequence(x1: Long, d1: Long, a: Long, c: Long, m: Long, l: Int) : LongArray {

    // Инициализация последовательности начальными данными
    val x = LongArray(l)
    val d = LongArray(l)
    x[0] = x1
    d[0] = d1

    // Вычисление значения элементов последовательности
    for (i in 1..(l - 1)) {
        d[i] = (a * d[i - 1] + c) % m
        x[i] = x[i - 1] + d[i - 1]
    }

    return x
}



fun calculateLeftMedianOfSequences(sequenceFirst: LongArray, sequenceSecond: LongArray) : Long {

    // Определение границ значения медианы
    var leftBorder = min(sequenceFirst[0], sequenceSecond[0])
    var rightBorder = max(sequenceFirst[sequenceFirst.lastIndex], sequenceSecond[sequenceSecond.lastIndex])

    // O(logK)
    while (leftBorder < rightBorder) {

        val middle = (leftBorder + rightBorder) / 2L

        // O(logL)
        val numberOfLessNumbers = determinateNumberOfNumbersLess(sequenceFirst, middle) +
                determinateNumberOfNumbersLess(sequenceSecond, middle)
        val numberOfHigherNumbers = determinateNumberOfNumbersMore(sequenceFirst, middle) +
                determinateNumberOfNumbersMore(sequenceSecond, middle)

        if ((numberOfLessNumbers < sequenceFirst.size) && (numberOfHigherNumbers <= sequenceFirst.size)) {
            // Определили медиану
            return middle
        }
        if (numberOfHigherNumbers > sequenceSecond.size) {
            // Левее медианы
            leftBorder = middle + 1
        }
        if (numberOfLessNumbers > sequenceFirst.size - 1) {
            // Правее медианы
            rightBorder = middle - 1
        }
    }

    return leftBorder
}



/**
 * Левый бинарный поиск с передаваемым условием `checkCondition`
 */
fun leftBinarySearch(sequence: LongArray, value: Long, checkCondition: (Long, Long) -> Boolean): Int {

    var leftBorder = 0
    var rightBorder = sequence.lastIndex

    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        if (checkCondition(sequence[middle], value)) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



/**
 * Определение количества элементов в последовательности, которые меньше медианы.
 */
fun determinateNumberOfNumbersLess(sequence: LongArray, value: Long) : Int {

    // Определение индекса первого элемента, значение которого больше либо равно предпологаемой медиане
    val index = leftBinarySearch(sequence, value) { item, value ->
        item >= value
    }

    if ((index == sequence.lastIndex) && (sequence[index] < value)) {
        // Все элементы последовательности меньше предпологаемой медианы
        return sequence.size

    } else {
        // Корректное определение количества элементов
        return index
    }
}



/**
 * Определение количества элементов в последовательности, которые больше медианы.
 */
fun determinateNumberOfNumbersMore(sequence: LongArray, value: Long) : Int {

    // Определение индекса первого элемента, значение которого больше предпологаемой медиане
    val index = leftBinarySearch(sequence, value) { item, value ->
        item > value
    }

    if ((index == sequence.lastIndex) && (sequence[index] <= value)) {
        // Все элементы последовательности меньше предпологаемой медианы
        return 0

    } else {
        // Корректное определение количества элементов
        return sequence.size - index
    }
}