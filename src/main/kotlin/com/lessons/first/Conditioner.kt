package com.lessons.first

/*
Время = 171ms
Память = 14.70Mb
 */
fun main() {
    val (troom, tcond) = readLine()!!.split(" ").map { it.toInt() }
    val mode = readln().trim()

    var result = troom

    when {
        (mode == "freeze") && (tcond < troom) -> result = tcond
        mode.equals("heat") && (tcond > troom) -> result = tcond
        mode == "auto" -> result = tcond
    }

    println(result)
}