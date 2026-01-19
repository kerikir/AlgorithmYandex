package com.lessons.fourth

import java.io.File


/*
Не решено - не сошелся ответ
 */
fun main() {
    val text = File("input.txt").readText().trim()

    val result = determinateOccurrenceNumbersOfWords(text)
    println(result)
}



fun determinateOccurrenceNumbersOfWords(text: String) : String {

    // Разделение слов по пробелам и переносам и фильтрация пустых слов
    val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }

    val occurrenceWords = mutableMapOf<String, Int>()
    val occurrenceNumbers = mutableListOf<Int>()

    // Пробег по всем словам
    words.forEach {
        if (it in occurrenceWords) {
            // Слово уже встречалось
            occurrenceNumbers.add(occurrenceWords[it]!!)
            occurrenceWords[it] = occurrenceWords[it]!! + 1
        } else {
            // Слово попалось впервые
            occurrenceNumbers.add(0)
            occurrenceWords[it] = 1
        }
    }

    return occurrenceNumbers.joinToString(" ")
}