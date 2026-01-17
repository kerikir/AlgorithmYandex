package com.lessons.third


/*
Время = 1.214s
Память = 65.81Mb

Сложность = O(3 * N + 3 * M + (K + L + P) * logN) = O(6 * (M + N)) = O(N + M)
 */
fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    // O(N)
    val anya = mutableListOf<Int>()
    for (i in 1..n) {
        anya.add(readLine()!!.trim().toInt())
    }

    // O(M)
    val borya = mutableListOf<Int>()
    for (i in 1..m) {
        borya.add(readLine()!!.trim().toInt())
    }


    // O(N + M + K * logK)
    val overallColors = determinateGeneralColorsOfDice(anya, borya)
    println(overallColors.size)
    println(overallColors.joinToString(" "))

    // O(N + M + P * logP)
    val colorsOnlyAnya = determinateColorsOfDiceAnya(anya, borya)
    println(colorsOnlyAnya.size)
    println(colorsOnlyAnya.joinToString(" "))

    // O(N + M + L * logL)
    val colorsOnlyBorya = determinateColorsOfDiceBorya(anya, borya)
    println(colorsOnlyBorya.size)
    println(colorsOnlyBorya.joinToString(" "))
}


/** Определение общих цветов в каждом наборе */
fun determinateGeneralColorsOfDice(list1: List<Int>, list2: List<Int>) : List<Int> {
    // O(N)
    val set1 = list1.toSet()
    // O(M)
    val set2 = list2.toSet()
    // O(min(N, M))
    val setIntersection = set1.intersect(set2)
    // O(K * logK)
    return setIntersection.sorted()
}


/** Определение цветов, которые есть только у Ани */
fun determinateColorsOfDiceAnya(list1: List<Int>, list2: List<Int>) : List<Int> {
    // O(N)
    val set1 = list1.toSet()
    // O(M)
    val set2 = list2.toSet()
    // O(N)
    val setSubtract = set1.subtract(set2)
    // O(P * logP)
    return setSubtract.sorted()
}


/** Определение цветов, которые есть только у Бори */
fun determinateColorsOfDiceBorya(list1: List<Int>, list2: List<Int>) : List<Int> {
    // O(N)
    val set1 = list1.toSet()
    // O(M)
    val set2 = list2.toSet()
    // O(M)
    val setSubtract = set2.subtract(set1)
    // O(L * logL)
    return setSubtract.sorted()
}