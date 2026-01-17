package com.lessons.third

import java.io.File


/*
Не решено
 */
fun main() {
    val text = File("input.txt").readText().trim()

    val result = determinateNumbersOfWords(text)
    println(result)
}


fun determinateNumbersOfWords(text: String) : Int {
    // Разделение слов по пробелам
    // Проверка что слово не пустое
    val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }.toSet()

    return words.size
}