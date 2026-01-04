package com.lessons.second


fun main() {
    val numbers = mutableListOf<Int>()
    while (true) {
        val input = readLine()!!.trim().toInt()

        if (input == -2_000_000_000) break
        else numbers.add(input)
    }

    val result = when {
        isConstant(list = numbers) -> "CONSTANT"
        else -> "RANDOM"
    }

    println(result)
}


fun isConstant(list: List<Int>) : Boolean {
    var flag = true
    for (i in 0..(list.lastIndex - 1)) {
        if (list[i] != list[i + 1]) {
            flag = false
        }
    }

    return flag
}