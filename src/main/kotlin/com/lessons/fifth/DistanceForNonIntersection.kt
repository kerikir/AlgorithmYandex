package com.lessons.fifth



/*
Время = 0.674s
Память = 56.91Mb

Сложность = O(N)
 */
fun main() {

    val (n, r) = readLine()!!.trim().split(' ').map { it.toInt() }
    val d = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNumberOfOptionForNonIntersection(d, r)
    println(result)
}



fun determinateNumberOfOptionForNonIntersection(
    distanceBetweenMonuments: List<Int>, visibilityDistance: Int
) : Long {

    // Заполнения префикс суммы для расстояний от первого памятника
    val distanceFromStart = IntArray(distanceBetweenMonuments.size)
    for (i in distanceFromStart.indices) {
        distanceFromStart[i] = distanceBetweenMonuments[i] - distanceBetweenMonuments[0]
    }

    // Расстояние видимости может быть нулевым и произойдет переполнение (каждый памятник подходит)
    var counter = 0L

    var right = 0

    // Сдвиг левого указателя
    for (left in distanceFromStart.indices) {

        // Сдвиг правого указателя
        while (right < distanceFromStart.size) {

            val distance = distanceFromStart[right] - distanceFromStart[left]

            // Расстояние достаточное
            if (distance > visibilityDistance) {

                // Оставшиеся дальше тоже подходят для левого памятника
                counter += distanceFromStart.size - right
                break

            } else {
                // Расстояния недостаточно
                right++
            }
        }
    }

    return counter
}