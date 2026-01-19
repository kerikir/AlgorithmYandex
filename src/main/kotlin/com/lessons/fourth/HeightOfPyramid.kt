package com.lessons.fourth


/*
Не решено - не сошелся ответ
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

    // Пробег по всем блокам
    sizesOfBlocks.forEach {

        // Первый блок с текущей широтой или самый высокий
        if ((it.first !in blocks) || (blocks[it.first]!! < it.second))
        {
            blocks[it.first] = it.second
        }
    }

    var sumHeights = 0L
    blocks.forEach { (_, height) ->
        sumHeights += height
    }

    return sumHeights
}