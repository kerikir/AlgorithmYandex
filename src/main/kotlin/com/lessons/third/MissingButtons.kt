package com.lessons.third


/*
Время = 180ms
Память = 15.21Mb

Сложность = O(1)
 */
fun main() {
    val buttons = readLine()!!.trim().split(" ").map { it.toInt() }
    val n = readLine()!!.trim().toInt()

    val result = determinateMissingButtons(buttons, n)
    println(result)
}


fun determinateMissingButtons(list: List<Int>, number: Int) : Int {

    // Определение из каких букв состоит нужное число
    val digits = number.toString()      // O(lgN)
        .map { it.toString().toInt() }  // O(K)
        .toSet()                        // O(K)

    // O(1)
    val set = list.toSet()

    // Определение нехватающих цифр
    val missingDigits = digits.subtract(set) // O(K)
    return missingDigits.size
}