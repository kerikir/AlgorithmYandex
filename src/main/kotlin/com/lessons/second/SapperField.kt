package com.lessons.second


/*
Время = 194ms
Память = 14.95Mb
 */
fun main() {

    val (n, m, k)  = readLine()!!.trim().split(" ").map { it.toInt() }
    val coords = mutableListOf<Pair<Int, Int>>()
    for (i in 1..k) {
        val (p, q) = readLine()!!.trim().split(" ").map { it.toInt() }
        coords.add(p to q)
    }

    val result = fillFieldWithMines(n, m, coords)
    println(result)
}



fun fillFieldWithMines(rows: Int, columns: Int, coords: List<Pair<Int, Int>>) : String {

    val field = Array(rows) { IntArray(columns) { 0 } }

    for (mine in coords) {
        for (i in -1..1) {
            for (j in -1..1) {
                if (
                    (mine.first + i <= rows) && (mine.second + j <= columns) &&
                    (mine.first + i >= 1) && (mine.second + j >= 1)
                ) {
                    field[mine.first + i - 1][mine.second + j - 1]++
                }
            }
        }
    }

    for (mine in coords) {
        field[mine.first - 1][mine.second - 1] = -1
    }

    var result = ""
    for (i in field.indices) {
        for (j in field[i].indices) {
            if (field[i][j] == -1) {
                result += "* "
            } else {
                result += "${field[i][j]} "
            }
        }

        result += "\n"
    }
    return result
}