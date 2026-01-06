package com.lessons.third


/*
Время = 1.214s
Память = 65.81Mb
 */
fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    val anya = mutableListOf<Int>()
    for (i in 1..n) {
        anya.add(readLine()!!.trim().toInt())
    }

    val borya = mutableListOf<Int>()
    for (i in 1..m) {
        borya.add(readLine()!!.trim().toInt())
    }


    val overallColors = determinateGeneralColorsOfDice(anya, borya)
    println(overallColors.size)
    println(overallColors.joinToString(" "))

    val colorsOnlyAnya = determinateColorsOfDiceAnya(anya, borya)
    println(colorsOnlyAnya.size)
    println(colorsOnlyAnya.joinToString(" "))

    val colorsOnlyBorya = determinateColorsOfDiceBorya(anya, borya)
    println(colorsOnlyBorya.size)
    println(colorsOnlyBorya.joinToString(" "))
}


fun determinateGeneralColorsOfDice(list1: List<Int>, list2: List<Int>) : List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    val setIntersection = set1.intersect(set2)
    return setIntersection.sorted()
}


fun determinateColorsOfDiceAnya(list1: List<Int>, list2: List<Int>) : List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    val setSubtract = set1.subtract(set2)
    return setSubtract.sorted()
}


fun determinateColorsOfDiceBorya(list1: List<Int>, list2: List<Int>) : List<Int> {
    val set1 = list1.toSet()
    val set2 = list2.toSet()
    val setSubtract = set2.subtract(set1)
    return setSubtract.sorted()
}