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

        val isCorrect = checkCorrectSizeBuildingProtection(middle, numberOfModules,
            moduleWidth, moduleHeight, fieldWidth, fieldHeight)

        if (isCorrect) {
            leftBorder = middle

        } else {
            rightBorder = middle - 1
        }
    }

    return leftBorder
}



fun checkCorrectSizeBuildingProtection(
    sizeBuildingProtection: Long, numberOfModules: Long, moduleWidth: Long,
    moduleHeight: Long, fieldWidth: Long, fieldHeight: Long
) : Boolean {

    var isCorrect = false

    // Размеры каждого модуля по ширине и высоте с защитой
    val sizeModuleByWidth = moduleWidth + 2 * sizeBuildingProtection
    val sizeModuleByHeight = moduleHeight + 2 * sizeBuildingProtection

    // Количество модулей по ширине и высоте на поле
    val numberOfModulesByWidth = fieldWidth / sizeModuleByWidth
    val numberOfModulesByHeight = fieldHeight / sizeModuleByHeight

    // Можно ли разместить все модули с текущей защитой
    if ((numberOfModulesByHeight * numberOfModulesByWidth) >= numberOfModules) {

        isCorrect = true
    }

    return isCorrect
}