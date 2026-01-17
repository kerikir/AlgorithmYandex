package com.lessons.third

import java.io.File


/*
Время = 461ms
Память = 41.36Mb

Сложность = O(L)
 */
fun main() {
    val text = File("input.txt").readText().trim()

    val result = determinateNumbersOfWords(text)
    println(result)
}


fun determinateNumbersOfWords(text: String) : Int {
    // Разделение слов по пробелам
    // Проверка что слово не пустое
    val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }.toSet() // O(L + N + M)

    return words.size
}