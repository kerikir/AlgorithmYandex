package com.lessons.fourth


/*
Время = 0.759s
Память = 44.44Mb

Сложность = O(N + M) = O(N)
 */
fun main() {
    val n = readLine()!!.trim().toInt()

    val sizesOfBlocks = mutableListOf<Pair<Int, Int>>()
    for (i in 1..n) {
        val (w, h) = readLine()!!.trim().split(" ").map { it.toInt() }
        sizesOfBlocks.add(w to h)
    }

    val result = determinateHeightOfPyramid(sizesOfBlocks)
    println(result)
}



fun determinateHeightOfPyramid(sizesOfBlocks: List<Pair<Int, Int>>) : Long {

    val blocks = mutableMapOf<Int, Int>()

    // O(N)
    // Пробег по всем блокам
    sizesOfBlocks.forEach {

        // Первый блок с текущей широтой или самый высокий
        if ((it.first !in blocks) || (blocks[it.first]!! < it.second))
        {
            blocks[it.first] = it.second
        }
    }

    // Исключение переполнения суммы Integer
    var sumHeights = 0L

    // O(M)
    // Перебор всех блоков с уникальной шириной в пирамиде
    blocks.forEach { (_, height) ->
        sumHeights += height
    }

    return sumHeights
}