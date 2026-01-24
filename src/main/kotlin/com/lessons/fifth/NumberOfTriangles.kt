package com.lessons.fifth


/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.trim().toInt()

    val coords = mutableListOf<Pair<Int, Int>>()
    repeat(n) {
        val (x, y) = readLine()!!.trim().split(' ').map { it.toInt() }
        coords.add(x to y)
    }

    val result = determinateNumberOfIsoscelesTriangles(coords)
    println(result)
}



fun determinateNumberOfIsoscelesTriangles(coords: List<Pair<Int, Int>>) : Int {

    var counter = 0

    // Перебор всех точек как начала координат
    for (i in coords.indices) {

        val distanceToPoints = mutableListOf<Int>()
        val verticesOfTriangle = mutableSetOf<Pair<Int, Int>>()

        // Расчет расстояния до каждой точки
        for (j in coords.indices) {

            if (i != j) {
                val dx = coords[j].first - coords[i].first
                val dy = coords[j].second - coords[i].second

                val distance = dx * dx + dy * dy
                distanceToPoints.add(distance)

                // Проверка точек лежащих на одной прямой
                if (coords[j] in verticesOfTriangle) {
                    counter--
                }
                val mirroredPoint = Pair(-coords[j].first, -coords[j].second)
                verticesOfTriangle.add(mirroredPoint)
            }
        }


    }

    return counter
}