package com.lessons.first

fun main() {
    val (troom, tcond) = readln().split(" ").map { it.toInt() }
    val mode = readln().trim()

    var result = troom

    when {
        (mode == "freeze") && (tcond < troom) -> result = tcond
        mode.equals("heat") && (tcond > troom) -> result = tcond
        mode == "auto" -> result = tcond
    }

    println(result)
}