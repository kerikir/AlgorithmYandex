package com.lessons.second


/*
Время = 173ms
Память = 14.57Mb

Сложность = O(N)
 */
fun main() {
    val list = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = if (isGrowingList(list)) "YES" else "NO"
    println(result)
}


fun isGrowingList(list: List<Int>) : Boolean {

    var flag = true

    for (i in 1..list.size - 1) {
        if (list[i] <= list[i - 1]) {
            flag = false
        }
    }

    return flag
}