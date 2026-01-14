package com.lessons.first

/*
Время = 171ms
Память = 14.70Mb

Сложность = O(1)
 */
fun main() {

    // O(1)
    val (troom, tcond) = readLine()!!.split(" ").map { it.toInt() }
    val mode = readln().trim()

    var result = troom

    // O(1)
    when {
        (mode == "freeze") && (tcond < troom) -> result = tcond
        mode.equals("heat") && (tcond > troom) -> result = tcond
        mode == "auto" -> result = tcond
    }

    // O(1)
    println(result)
}