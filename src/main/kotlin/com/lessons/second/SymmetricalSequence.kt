package com.lessons.second


/*
Время = 176ms
Память = 14.57Mb
 */
fun main() {
    val size = readLine()!!.trim().toInt()
    val numbers = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = additionSymmetricSequence(numbers)

    if (result.isNullOrEmpty()) {
        println(result.size)
    } else {
        println(result.size)
        println(result.joinToString(" "))
    }
}


fun additionSymmetricSequence(list: List<Int>) : List<Int> {
    val mutableList = mutableListOf<Int>()

    var indexStart = 0
    var missingNumbers = -1
    var indexEnd = list.lastIndex

    while (indexStart < indexEnd) {

        if (list[indexStart] == list[indexEnd]) {
            indexStart++
            indexEnd--
        } else {
            indexEnd = list.lastIndex

            missingNumbers = indexStart
            indexStart++
        }
    }

    if (missingNumbers >= 0) {
        for (i in missingNumbers downTo 0) {
            mutableList.add(list[i])
        }
    }

    return mutableList
}