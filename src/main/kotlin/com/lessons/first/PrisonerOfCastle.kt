package com.lessons.first


/*
Время = 186ms
Память = 18.05Mb
 */
fun main() {
    val x = readLine()!!.trim().toInt()
    val y = readLine()!!.trim().toInt()
    val z = readLine()!!.trim().toInt()
    val a = readLine()!!.trim().toInt()
    val b = readLine()!!.trim().toInt()

    val result = if (isThroughTheHole(x, y, z, a, b)) "YES" else "NO"
    println(result)
}


fun isThroughTheHole(x: Int, y: Int, z: Int, a: Int, b: Int) : Boolean {

    val brick = listOf(x, y, z)
    val hole = listOf(a, b)

    var flag = false

    if (x <= a && y <= b) flag = true
    else if (x <= b && y <= a) flag = true
    else if (x <= a && z <= b) flag = true
    else if (x <= b && z <= a) flag = true
    else if (y <= a && z <= b) flag = true
    else if (y <= b && z <= a) flag = true

    return flag
}