package com.lessons.third


/*
Время = 0.698s
Память = 38.41Mb
 */
fun main() {
    val numbers1 = readLine()!!.trim().split(" ").map { it.toInt() }
    val numbers2 = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = definingCommonNumbers(numbers1, numbers2)
    println(result.joinToString(" "))
}


fun definingCommonNumbers(list1: List<Int>, list2: List<Int>) : List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    val setIntersection = set1.intersect(set2)
    return setIntersection.sorted()
}