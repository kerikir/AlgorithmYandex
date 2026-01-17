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
    // Удаление знаков пунктуации
    val textOneLine = text.replace(Regex("\\s+"), " ").trim()

    val words = textOneLine.split(" ").toSet()
    return words.size
}