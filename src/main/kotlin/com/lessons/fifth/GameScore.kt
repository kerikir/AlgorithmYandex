package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val x = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateVariationsOfGameScore(x, k)
    println(result)
}



fun determinateVariationsOfGameScore(cards: List<Int>, maxDiff: Int) : Long {

    var counter = 0L

    val numberOfCards = mutableMapOf<Int, Int>()

    // Определение количества каждой карточки
    for (card in cards) {

        val count = numberOfCards.getOrDefault(card, 0)
        numberOfCards[card] = count + 1
    }

    return counter
}