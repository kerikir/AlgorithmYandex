package com.lessons.fourth

import java.io.File


/*
Время = 0.662s
Память = 48.36Mb

Сложность = O(L + N + M + K * W) = O(L)
*/
fun main() {
    val text = File("input.txt").readText()

    val result = determinateMostFrequentWord(text)
    println(result)
}



fun determinateMostFrequentWord(text: String) : String {

    // Очистка строки и разделение по словам
    val words = text.trim().replace(Regex("\\s+"), " ").split(" ") // O(3 * L)

    val frequencyWords = mutableMapOf<String, Int>()

    // O(N)
    // Подсчет частоты каждого слова
    words.forEach {
        // O(1)
        if (it in frequencyWords) {
            frequencyWords[it] = frequencyWords[it]!! + 1
        } else {
            frequencyWords[it] = 1
        }
    }

    // Поиск максимальной частоты
    val maxFrequency = frequencyWords.values.max()  // O(M)
    // Фильтрация слов с максимальной частотой
    val mostFrequentWords = frequencyWords.filter { it.value == maxFrequency }.keys  // O(M)

    // Выбор минимального в лексикографическом порядке
    return mostFrequentWords.minOf { it }   // O(K * W)
}