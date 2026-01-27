package com.lessons.sixth



/*
Время = 289ms
Память = 18.70Mb

Сложность = O(N * logM) = O(N)
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

    // Из-за правого бинарного поиска никогда не поделит на 0
    var leftBorder = 0L
    // Максимальная длина отрезка - максимальная длина самого длинного провода
    var rightBorder = Math.pow(10.0, 7.0).toLong()

    // O(logM)
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
    for (wires in lengthOfWires) {          // O(N)

        counterWires += wires / segmentLength
    }

    return counterWires >= numberOfWires
}