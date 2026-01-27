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
    copyTime: Int, numberOfCopies: Int, copyTimeOnFirstPrinter: Int, copyTimeOnSecondPrinter: Int
) : Boolean {

    // Необходимое время для старта второго принтера
    val firstCopyTime = min(copyTimeOnFirstPrinter, copyTimeOnSecondPrinter)

    // Времени не хватило даже на 1 копию
    if (firstCopyTime > copyTime)
        return false

    val remainTime = copyTime - firstCopyTime

    // Копирование экземпляров на двух принтерах в оставшееся время
    var counterCopies = 1
    counterCopies += remainTime / copyTimeOnFirstPrinter
    counterCopies += remainTime / copyTimeOnSecondPrinter

    if (counterCopies >= numberOfCopies) {
        return true

    } else {
        return false
    }
}