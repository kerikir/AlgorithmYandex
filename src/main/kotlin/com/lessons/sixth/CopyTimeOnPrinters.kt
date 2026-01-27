package com.lessons.sixth

import kotlin.math.min



/*
Время =
Память =
 */
fun main() {

    val (n, x, y) = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateCopyTimeOnPrinters(n, x, y)
    println(result)
}



/**
 * Левый бинарный поиск.
 * Поиск наименьшего времени для печати `numberOfCopies` копий.
 */
fun determinateCopyTimeOnPrinters(numberOfCopies: Int, copyTimeOnFirstPrinter: Int, copyTimeOnSecondPrinter: Int)
: Int {

    var leftBorder = 1
    // Максимальное время копии - все копии на одном принтере
    var rightBorder = numberOfCopies * min(copyTimeOnFirstPrinter, copyTimeOnSecondPrinter)


    // Поиск наименьшего времени для копий всех экземпляров
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        val isCorrect = true

        if (isCorrect) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}