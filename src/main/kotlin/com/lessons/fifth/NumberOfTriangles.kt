package com.lessons.fifth


/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.toInt()

    val coords = ArrayList<Pair<Int, Int>>(n)
    for (i in 0 until n) {
        val (x, y) = readLine()!!.split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val result = determinateNumberOfIsoscelesTriangles(coords)
    println(result)
}



fun determinateNumberOfIsoscelesTriangles(coords: List<Pair<Int, Int>>) : Int {

    var counter = 0

    // Перебор всех точек как начала координат
    for (i in 0..coords.lastIndex) {

        val distanceToPoints = ArrayList<Int>(coords.size)
        val verticesOfTriangle = HashSet<Pair<Int, Int>>(coords.size)

        // Расчет расстояния до каждой точки
        for (j in coords.indices) {

            val dx = coords[j].first - coords[i].first
            val dy = coords[j].second - coords[i].second

            // Определяем квадрат длины
            val distance = dx * dx + dy * dy
            distanceToPoints.add(distance)

            // Проверка точек лежащих на одной прямой
            val point = Pair(dx, dy)
            if (point in verticesOfTriangle) {
                counter--
            }
            verticesOfTriangle.add(-dx to -dy)
        }

        // Сортируем вершины по расстоянию от начала координат
        val sortedDistanceToPoints = distanceToPoints.sorted()

        var right = 0
        // Двигаем левый указатель
        for (left in 0..sortedDistanceToPoints.lastIndex) {

            // Двигаем правый указатель
            while (
                (right < sortedDistanceToPoints.size) &&
                (sortedDistanceToPoints[left] == sortedDistanceToPoints[right])
            ) {
                right++
            }

            // Количество равнобедренных треугольников с текущей стороной
            counter += (right - left - 1)
        }
    }

    return counter
}