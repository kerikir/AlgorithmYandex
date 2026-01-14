package com.lessons.second

import kotlin.math.abs


/*
Время = 173ms
Память = 14.82Mb

Сложность = O(N)
 */
fun main() {
    val size = readLine()!!.trim().toShort()
    val numbers = readLine()!!.trim().split(" ").map { it.toShort() }
    val number = readLine()!!.trim().toShort()

    val result = definitionNearestNumber(numbers, number)
    println(result)
}


fun definitionNearestNumber(list: List<Short>, number: Short) : Short {

    var diff = abs(number - list[0]).toShort()
    var index = 0
    var currentDiff: Short

    for (i in list.indices) {
        currentDiff = abs(number - list[i]).toShort()

        if (currentDiff < diff) {
            diff = currentDiff
            index = i
        }
    }

    return list[index]
}