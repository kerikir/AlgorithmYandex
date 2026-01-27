package com.lessons.sixth

import kotlin.math.min


/*
Время =
Память =
 */
fun main() {

    val (n, a, b, w, h) = readLine()!!.trim().split(' ').map { it.toLong() }

    val result = determinateMaxSizeBuildingProtection(n, a, b, w, h)
    println(result)
}



/**
 * Правый бинарный поиск.
 * Поиск наибольшей толщины дополнительной защиты.
 */
fun determinateMaxSizeBuildingProtection(
    numberOfModules: Long, moduleWidth: Long, moduleHeight: Long, fieldWidth: Long, fieldHeight: Long
) : Long {

    var leftBorder = 0L
    var rightBorder = min(fieldWidth, fieldHeight)

    // Поиск максимальной допустимой ширины дополнительной защиты
    while (leftBorder < rightBorder) {

        val middle = (leftBorder + rightBorder + 1) / 2

        if (true) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }
}