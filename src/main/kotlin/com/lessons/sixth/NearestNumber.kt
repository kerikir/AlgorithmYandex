package com.lessons.sixth


/*
Время =
Память =
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