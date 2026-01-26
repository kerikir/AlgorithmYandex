package com.lessons.sixth

import kotlin.math.abs


/*
Время = 0.953s
Память = 43.61Mb
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val arrayN = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
    val listK = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNearestNumber(arrayN, listK)
    println(result)
}



fun determinateNearestNumber(array: IntArray, listNumbers: List<Int>) : String {

    val resultList = mutableListOf<String>()

    // Пробег по всем числам
    for (number in listNumbers) {

        val a = binarySearchSmallerNumber(array, number)
        val b = binarySearchLargerNumber(array, number)

        // Сравнение близости к числу
        if (abs(a - number) <= abs(b - number)) {
            resultList.add(a.toString())

        } else {
            resultList.add(b.toString())
        }
    }

    return resultList.joinToString("\n")
}



/**
 * Левый бинарный поиск.
 * Поиск наименьшего числа из больше либо равных `number`.
 */
fun binarySearchLargerNumber(array: IntArray, number: Int) : Int {

    var leftBorder = 0
    var rightBorder = array.lastIndex

    // Поиск первого элемента массива >= числу
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        if (array[middle] >= number) {

            rightBorder = middle

        } else {

            leftBorder = middle + 1
        }
    }

    return array[leftBorder]
}



/**
 * Правый бинарный поиск.
 * Поиск наибольшего числа из меньше либо равных `number`.
 */
fun binarySearchSmallerNumber(array: IntArray, number: Int) : Int {

    var leftBorder = 0
    var rightBorder = array.lastIndex

    // Поиск последнего элемента массива <= числу
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1) / 2

        if (array[middle] <= number) {

            leftBorder = middle

        } else {

            rightBorder = middle - 1
        }
    }

    return array[leftBorder]
}