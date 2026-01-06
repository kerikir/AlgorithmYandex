package com.lessons.third

import java.io.File

fun main() {
    val text = File("input.txt").readText()

    val result = determinateNumbersOfWords(text)
    File("output.txt").writeText(result.toString())
}


fun determinateNumbersOfWords(text: String) : Int {
    // Удаление знаков пунктуации
    //val cleanText = text.replace("[,.;:!?]".toRegex(), "")
    val textOneLine = text.replace("[\\s+]".toRegex(), " ").replace("\\s+".toRegex(), " ")

    val words = textOneLine/*.toLowerCase()*/.split(" ").toSet()
    return words.size
}