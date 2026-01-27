package com.lessons.sixth

import kotlin.math.min



/*
Время = 173ms
Память = 14.70Mb
 */
fun main() {

    // Был TL, но решилось переходом с Int на Long (переполнение - WA)
    val (n, x, y) = readLine()!!.trim().split(" ").map { it.toLong() }

    val result = determinateCopyTimeOnPrinters(n, x, y)
    println(result)
}



/**
 * Левый бинарный поиск.
 * Поиск наименьшего времени для печати `numberOfCopies` копий.
 */
fun determinateCopyTimeOnPrinters(
    numberOfCopies: Long, copyTimeOnFirstPrinter: Long, copyTimeOnSecondPrinter: Long
) : Long {

    var leftBorder = 1L
    // Максимальное время копии - все копии на одном принтере
    var rightBorder = numberOfCopies * copyTimeOnFirstPrinter


    // Поиск наименьшего времени для копий всех экземпляров
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        val isCorrect = checkCorrectCopyTimeOnPrinters(middle, numberOfCopies,
            copyTimeOnFirstPrinter, copyTimeOnSecondPrinter)

        if (isCorrect) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun checkCorrectCopyTimeOnPrinters(
    copyTime: Long, numberOfCopies: Long, copyTimeOnFirstPrinter: Long, copyTimeOnSecondPrinter: Long
) : Boolean {

    // Необходимое время для старта второго принтера
    val firstCopyTime = min(copyTimeOnFirstPrinter, copyTimeOnSecondPrinter)

    // Времени не хватило даже на 1 копию
    if (firstCopyTime > copyTime)
        return false

    val remainTime = copyTime - firstCopyTime

    // Копирование экземпляров на двух принтерах в оставшееся время
    var counterCopies = 1L + (remainTime / copyTimeOnFirstPrinter) + (remainTime / copyTimeOnSecondPrinter)

    return counterCopies >= numberOfCopies
}