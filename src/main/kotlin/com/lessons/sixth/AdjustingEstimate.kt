package com.lessons.sixth



/*
Время =
Память =
 */
fun main() {

    val a = readLine()!!.trim().toLong()
    val b = readLine()!!.trim().toLong()
    val c = readLine()!!.trim().toLong()

    val result = determinateNumberOfFives(a, b, c)
    println(result)
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

        val isCorrect = checkCorrectNumberOfFives(middle, numberOfTwos, numberOfTriples, numberOfFours)

        if (isCorrect) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun checkCorrectNumberOfFives(
    numberOfFives: Long, numberOfTwos: Long, numberOfTriples: Long, numberOfFours: Long
) : Boolean {

    // Избавлено от использования вещественных чисел
    val isCorrect = (3L * numberOfFives) >= (3L * numberOfTwos + numberOfTriples - numberOfFours)
    return isCorrect
}