package com.lessons.sixth


/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val arrayN = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
    val listK = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNearestNumber(arrayN, listK)
    println(result)
}



fun determinateNearestNumber(array: IntArray, listNumbers: List<Int>) : String {

    val resultList = mutableListOf<String>()

    return resultList.joinToString("\n")
}