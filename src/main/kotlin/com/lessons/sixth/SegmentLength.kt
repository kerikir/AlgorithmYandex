package com.lessons.sixth



/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val lengthOfWires = mutableListOf<Long>()
    repeat(n) {
        val l = readLine()!!.trim().toLong()
        lengthOfWires.add(l)
    }
}



fun determinateSegmentLength(lengthOfWires: List<Long>, numberOfWires: Int) : Long {

    var leftBorder = 0L
    var rightBorder = Math.pow(10.0, 11.0).toLong()

    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1L) / 2

        val isCorrect = true

        if (isCorrect) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }

    return leftBorder
}