package com.lessons.first


/*
Время = 161ms
Память = 13.79Mb

Сложность = O(1)
 */
fun main() {
    // O(1)
    val a = readLine()!!.trim().toInt()
    val b = readLine()!!.trim().toInt()
    val c = readLine()!!.trim().toInt()

    // O(1)
    val result: String = if (
        (a + b > c) &&
        (a + c > b) &&
        (c + b > a)
    ) {
        "YES"
    } else {
        "NO"
    }

    // O(1)
    print(result)
}