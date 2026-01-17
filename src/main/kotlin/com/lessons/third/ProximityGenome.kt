package com.lessons.third


/*
Время = 412ms
Память = 31.77Mb

Результат = 100 баллов

Сложность = O(N + M)
 */
fun main() {
    val genome1 = readLine()!!.trim()
    val genome2 = readLine()!!.trim()

    val result = determinateProximityGenome(genome1, genome2)
    println(result)
}


fun determinateProximityGenome(genome1: String, genome2: String) : Int {

    // Получение всех пар соседних оснований
    val pairGenome1 = genome1.windowed(2, 1)            // O(N)
    val pairGenome2 = genome2.windowed(2, 1).toSet()    // O(M)

    // Подсчет количество пар оснований которые совпадают с другими парами оснований генома
    val degreeProximity = pairGenome1.count { pairGenome2.contains(it) } // O(N)
    return degreeProximity
}