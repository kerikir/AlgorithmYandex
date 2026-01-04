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
        isAscending(numbers) -> "ASCENDING"
        isWeaklyAscending(numbers) -> "WEAKLY ASCENDING"
        isDescending(numbers) -> "DESCENDING"
        isWeaklyDescending(list = numbers) -> "WEAKLY DESCENDING"
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


fun isAscending(list: List<Int>) : Boolean {
    var flag = true
    for (i in 1..list.lastIndex) {
        if (list[i - 1] >= list[i]) {
            flag = false
        }
    }

    return flag
}


fun isWeaklyAscending(list: List<Int>) : Boolean {
    var flag = true
    for (i in 1..list.lastIndex) {
        if (list[i - 1] > list[i]) {
            flag = false
            break
        }
    }

    return flag
}


fun isDescending(list: List<Int>) : Boolean {
    var flag = true
    for (i in 1..list.lastIndex) {
        if (list[i - 1] <= list[i]) {
            flag = false
            break
        }
    }

    return flag
}


fun isWeaklyDescending(list: List<Int>) : Boolean {
    var flag = true

    for (i in 1..list.lastIndex)
        if (list[i - 1] < list[i]) flag = false

    return flag
}