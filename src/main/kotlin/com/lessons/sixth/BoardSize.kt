package com.lessons.sixth

import kotlin.math.min



/*
Время =
Память =
 */
fun main() {

    val (w, h, n) = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinBoardSize(n, h, w)
    println(result)
}



fun determinateMinBoardSize(numberOfDiplomas: Int, diplomaHeight: Int, diplomaWidth: Int) : Int {

    var maxBoardSize = numberOfDiplomas * min(diplomaHeight, diplomaWidth)

    val sizesOfBoard = IntArray(maxBoardSize) { it + 1 }

    val size = binarySearchBoardSize(sizesOfBoard, numberOfDiplomas, diplomaHeight, diplomaWidth)

    return size
}



/**
 * Левый бинарный поиск.
 * Поиск наименьшего размера каждой стороны доски.
 */
fun binarySearchBoardSize(sizesOfBoard: IntArray, numberOfDiplomas: Int, diplomaHeight: Int, diplomaWidth: Int)
: Int {

    var leftBorder = 0
    var rightBorder = sizesOfBoard.lastIndex

    // Поиск минимальных размеров доски для всех дипломов
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        val isCorrect = checkCorrectSizeBoard(sizesOfBoard[middle], numberOfDiplomas, diplomaHeight, diplomaWidth)

        if (isCorrect) {
            rightBorder = middle
        } else {
            leftBorder = middle + 1
        }
    }

    return sizesOfBoard[leftBorder]
}



fun checkCorrectSizeBoard(size: Int, numberOfDiplomas: Int, diplomaHeight: Int, diplomaWidth: Int)
: Boolean {

    // Проверка можно ли поместить все дипломы на доску
    val isCorrect = ((size / diplomaHeight) * (size / diplomaWidth)) >= numberOfDiplomas

    return isCorrect
}