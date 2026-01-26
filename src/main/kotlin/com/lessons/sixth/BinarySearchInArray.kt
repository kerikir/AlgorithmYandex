package com.lessons.sixth


/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val arrayN = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
    val arrayK = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
}


fun searchNumbersInArray(arrayN: IntArray, arrayK: IntArray) : String {

    val resultList = mutableListOf<String>()

    return resultList.joinToString("\n")
}