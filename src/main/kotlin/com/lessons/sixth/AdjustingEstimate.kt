package com.lessons.sixth



/*
Время =
Память =
 */
fun main() {

    val (a, b, c) = readLine()!!.trim().split(' ').map { it.toLong() }
}



/**
 * Левый бинарный поиск.
 * Поиск наименьшего количество пятерок для исправления итоговой оценки.
 */
fun determinateNumberOfFives(numberOfTwos: Long, numberOfTriples: Long, numberOfFours: Long) : Long {

    var leftBorder = 0L
    // Максимальное количество пятерок - компенсировать все двойки и тройки
    var rightBorder = numberOfTwos + numberOfTriples

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