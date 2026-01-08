package com.lessons.fourth


/*
Не решено
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


fun determinateHeightOfPyramid(sizesOfBlocks: List<Pair<Int, Int>>) : Int {

    val blocks = mutableMapOf<Int, Int>()
    sizesOfBlocks.forEach {
        if ((it.first !in blocks) || (blocks[it.first]!! < it.second))
        {
            blocks[it.first] = it.second
        }
    }

    return blocks.values.sum()
}