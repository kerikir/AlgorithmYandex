package com.lessons.fifth

import kotlin.math.abs



/*
Время = 0.641s
Память = 36.82Mb

Сложность = O(N + M)
 */
fun main() {

    val n = readLine()!!.trim().toInt()
    val colorsTShirt = readLine()!!.trim().split(' ').map { it.toInt() }    // O(N)

    val m = readLine()!!.trim().toInt()
    val colorsPants = readLine()!!.trim().split(' ').map { it.toInt() }     // O(M)

    val result = determinateColorsOfTShirtAndPants(colorsTShirt, colorsPants)
    println("${result.first} ${result.second}")
}



fun determinateColorsOfTShirtAndPants(colorsTShirt: List<Int>, colorsPants: List<Int>) : Pair<Int, Int> {

    // Второй указатель на цвет штанов
    var secondPointer = 0

    // Минимальная разница в цвете элементов одежды
    var minColorDifference = abs(colorsTShirt[0] - colorsPants[0])
    var colorTShirt = colorsTShirt[0]
    var colorPants = colorsPants[0]

    // Сдвиг левого указателя
    for (firstPointer in 0..colorsTShirt.lastIndex) {   // O(N)

        // Сдвиг правого указателя
        while (secondPointer < colorsPants.size) {      // O(M)

            val currentColorDifference = abs(colorsTShirt[firstPointer] - colorsPants[secondPointer])

            // Новые цвета более стильные
            if (currentColorDifference < minColorDifference) {

                minColorDifference = currentColorDifference
                colorTShirt = colorsTShirt[firstPointer]
                colorPants = colorsPants[secondPointer]
            }

            if (colorsTShirt[firstPointer] < colorsPants[secondPointer]) {
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