package com.lessons.third


/*
Время = 180ms
Память = 15.21Mb
 */
fun main() {
    val buttons = readLine()!!.trim().split(" ").map { it.toInt() }
    val n = readLine()!!.trim().toInt()

    val result = determinateMissingButtons(buttons, n)
    println(result)
}


fun determinateMissingButtons(list: List<Int>, number: Int) : Int {

    // Определение из каких букв состоит нужное число
    val digits = number.toString().map { it.toString().toInt() }.toSet()
    val set = list.toSet()

    // Определение нехватающих цифр
    val missingDigits = digits.subtract(set)
    return missingDigits.size
}