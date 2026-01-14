package com.lessons.seventh

/*
Время = 379ms
Память = 25.45Mb

Сложность = O(M*logM)
Память = O(M)
 */
fun main() {
    val (n, m) = readLine()!!.trim().split(" ").map { it.toInt() }
    val checkingDesks = mutableListOf<Pair<Int, Int>>()
    for (i in 1..m) {
        val (b, e) = readLine()!!.trim().split(" ").map { it.toInt() }
        checkingDesks.add(b to e)
    }

    val result = determinateNumberOfStudentsWithoutSupervision(n, checkingDesks)
    println(result)
}


fun determinateNumberOfStudentsWithoutSupervision(numberOfDesks: Int, checkingDesks: List<Pair<Int, Int>>) : Int {

    // Сортировка интервалов по началу
    val checkingDesksSorted = checkingDesks.sortedBy { it.first }

    var counterDesksObserved = 0
    var maxEnd = -1

    for ((start, end) in checkingDesksSorted) {
        if (maxEnd < start) {
            // Интервалы не пересекаются - наблюдают за разными партами
            counterDesksObserved += end - start + 1
            maxEnd = end
        } else if (maxEnd < end) {
            // Интервалы пересекаются
            counterDesksObserved += end - maxEnd
            maxEnd = end
        }
    }

    return numberOfDesks - counterDesksObserved
}