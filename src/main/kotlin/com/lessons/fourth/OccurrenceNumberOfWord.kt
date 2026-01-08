package com.lessons.fourth

import java.io.File


/*
Не решено - не сошелся ответ
 */
fun main() {
    val text = File("input.txt").readText()

    val result = determinateOccurrenceNumbersOfWords(text)
    println(result)
}



fun determinateOccurrenceNumbersOfWords(text: String) : String {

    val words = text.trim().replace(Regex("\\s+"), " ").split(" ")

    val occurrenceWords = mutableMapOf<String, Int>()
    val occurrenceNumbers = mutableListOf<Int>()

    words.forEach {
        if (it in occurrenceWords) {
            occurrenceNumbers.add(occurrenceWords[it]!!)
            occurrenceWords[it] = occurrenceWords[it]!! + 1
        } else {
            occurrenceNumbers.add(0)
            occurrenceWords[it] = 1
        }
    }

    return occurrenceNumbers.joinToString(" ")
}