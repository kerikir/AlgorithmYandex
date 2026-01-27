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

    val result = determinateSegmentLength(lengthOfWires, k)
    println(result)
}



fun determinateSegmentLength(lengthOfWires: List<Long>, numberOfWires: Int) : Long {

    var leftBorder = 0L
    var rightBorder = Math.pow(10.0, 11.0).toLong()

    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder + 1L) / 2

        val isCorrect = checkCorrectSegmentLength(middle, lengthOfWires, numberOfWires)

        if (isCorrect) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }

    return leftBorder
}



fun checkCorrectSegmentLength(segmentLength: Long, lengthOfWires: List<Long>, numberOfWires: Int) : Boolean {

    var counterWires = 0L

    // Подсчет числа отрезков соответствующего размера из каждого провода
    for (wires in lengthOfWires) {

        counterWires += wires / segmentLength
    }

    return counterWires >= numberOfWires
}