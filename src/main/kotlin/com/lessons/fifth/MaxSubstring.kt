package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val str = readLine()!!.trim()

    val result = determinateMaxSubstring(str, k)
    println("${result.first} ${result.second}")
}



fun determinateMaxSubstring(string: String, maxRepeat: Int) : Pair<Int, Int> {

    return 1 to 1
}