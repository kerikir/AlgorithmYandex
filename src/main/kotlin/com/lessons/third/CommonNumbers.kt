package com.lessons.third


/*
Время = 0.698s
Память = 38.41Mb

Сложность = O(N + M + K * logK)
 */
fun main() {
    val numbers1 = readLine()!!.trim().split(" ").map { it.toInt() }
    val numbers2 = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = definingCommonNumbers(numbers1, numbers2)
    println(result.joinToString(" "))
}


fun definingCommonNumbers(list1: List<Int>, list2: List<Int>) : List<Int> {
    // O(N)
    val set1 = list1.toSet()
    // O(M)
    val set2 = list2.toSet()
    // O(min(N, M))
    val setIntersection = set1.intersect(set2)
    // O(K * logK)
    return setIntersection.sorted()
}