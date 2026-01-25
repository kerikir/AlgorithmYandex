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

    // Все уникальные значения счета
    val scoreCards = numberOfCards.keys.sorted()

    var dublicated = 0

    var right = 0
    // Двигаем левый указатель - уникальная карточка счета
    for (left in scoreCards.indices) {

        // Двигаем правый указатель - допустимая карточка для разницы в счете
        while (
            (right < scoreCards.size) &&
            (scoreCards[right].toLong() <= (scoreCards[left] * maxDiff.toLong()))
        ) {
            // Считаем количество дубликатов каждой подходящей карточки
            if (numberOfCards[scoreCards[right]]!! >= 2) {
                dublicated++
            }

            right++
        }

        // Ведущая карточка повторяется один раз с разными карточками
        counter += 3L * (right - left - 2) * (right - left - 1)

        // Ведущая карточка повторяется два раза с разными карточками
        if (numberOfCards[scoreCards[left]]!! >= 2) {

            counter += (right - left - 1) * 3L
            dublicated--
        }

        // Ведущая карточка повторяется три раза
        if (numberOfCards[scoreCards[left]]!! >= 3) {

            counter += 1L
        }

        // Ведущая карточка повторяется один раз с дубликатоми каждой карточки
        counter += 3L * dublicated
    }

    return counter
}