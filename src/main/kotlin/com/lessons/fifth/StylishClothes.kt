package com.lessons.fifth

import kotlin.math.abs


fun main() {

    val n = readLine()!!.trim().toInt()
    val colorsTShirt = readLine()!!.trim().split(' ').map { it.toInt() }

    val m = readLine()!!.trim().toInt()
    val colorsPants = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateColorsOfTShirtAndPants(colorsTShirt, colorsPants)
    println("${result.first} ${result.second}")
}



fun determinateColorsOfTShirtAndPants(colorsTShirt: List<Int>, colorsPants: List<Int>) : Pair<Int, Int> {

    // Второй указатель на цвет штанов
    var secondPointer = 1

    // Минимальная разница в цвете элементов одежды
    var minColorDifference = abs(colorsTShirt[0] - colorsPants[0])
    var colorTShirt = colorsTShirt[0]
    var colorPants = colorsPants[0]

    // Сдвиг левого указателя
    for (firstPointer in 0..colorsTShirt.lastIndex) {

        // Сдвиг правого указателя
        while (secondPointer < colorsPants.size) {

            val currentColorDifference = abs(colorsTShirt[firstPointer] - colorsPants[secondPointer])

            // Новые цвета более стильные
            if (currentColorDifference < minColorDifference) {

                minColorDifference = currentColorDifference
                colorTShirt = colorsTShirt[firstPointer]
                colorPants = colorsPants[secondPointer]
            }

            if (colorsTShirt[firstPointer] <= colorsPants[secondPointer]) {
                // К текущей майке не подобрать штанов лучше
                break

            } else {
                // Подбираем штаны к майке получше
                secondPointer++
            }
        }
    }

    return colorTShirt to colorPants
}