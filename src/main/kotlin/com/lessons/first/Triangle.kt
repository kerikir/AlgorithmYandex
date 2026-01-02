package com.lessons.first


/*
Время = 161ms
Память = 13.79Mb
 */
fun main() {
    val a = readLine()!!.trim().toInt()
    val b = readLine()!!.trim().toInt()
    val c = readLine()!!.trim().toInt()

    val result: String = if (
        (a + b > c) &&
        (a + c > b) &&
        (c + b > a)
    ) {
        "YES"
    } else {
        "NO"
    }

    print(result)
}