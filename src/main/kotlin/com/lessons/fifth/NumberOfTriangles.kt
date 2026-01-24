package com.lessons.fifth


/*
Время = 1.72s
Память = 38.19Mb

Сложность = O(N^2 * logN)
 */
fun main() {

    val n = readLine()!!.toInt()

    val coords = Array(n) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }
        x to y
    }

    val result = determinateNumberOfIsoscelesTriangles(coords)
    println(result)
}



fun determinateNumberOfIsoscelesTriangles(coords: Array<Pair<Int, Int>>) : Int {

    var counter = 0

    // Перебор всех точек как начала координат
    for (i in coords.indices) {

        val distanceToPoints = mutableListOf<Long>()
        val verticesOfTriangle = mutableSetOf<Pair<Int, Int>>()

        // Расчет расстояния до каждой точки
        for (j in coords.indices) {

            if (i != j) {
                val dx = coords[j].first - coords[i].first
                val dy = coords[j].second - coords[i].second

                // Определяем квадрат длины
                val distance = dx * dx.toLong() + dy * dy.toLong()
                distanceToPoints.add(distance)

                // Проверка точек лежащих на одной прямой
                val point = Pair(dx, dy)
                if (point in verticesOfTriangle) {
                    counter--
                }
                verticesOfTriangle.add(-dx to -dy)
            }
        }

        // Сортируем вершины по расстоянию от начала координат
        distanceToPoints.sort()

        var right = 0
        // Двигаем левый указатель
        for (left in distanceToPoints.indices) {

            // Двигаем правый указатель
            while (
                (right < distanceToPoints.size) &&
                (distanceToPoints[left] == distanceToPoints[right])
            ) {
                right++
            }

            // Количество равнобедренных треугольников с текущей стороной
            counter += (right - left - 1)
        }
    }

    return counter
}