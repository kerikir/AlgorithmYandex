package com.lessons.fifth



fun main() {

    val (n, r) = readLine()!!.trim().split(' ').map { it.toInt() }
    val d = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNumberOfOptionForNonIntersection(d, r)
    println(result)
}



fun determinateNumberOfOptionForNonIntersection(
    distanceBetweenMonuments: List<Int>, visibilityDistance: Int
) : Int {

    // Заполнения префикс суммы для расстояний от первого памятника
    val distanceFromStart = IntArray(distanceBetweenMonuments.size)
    for (i in distanceFromStart.indices) {
        distanceFromStart[i] = distanceBetweenMonuments[i] - distanceBetweenMonuments[0]
    }

    var counter = 0

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