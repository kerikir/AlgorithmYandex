package com.lessons.fourth

import java.io.File


/*
Время = 0.662s
Память = 48.36Mb
*/
fun main() {
    val text = File("input.txt").readText()

    val result = determinateMostFrequentWord(text)
    println(result)
}



fun determinateMostFrequentWord(text: String) : String {

    val words = text.trim().replace(Regex("\\s+"), " ").split(" ")

    val frequencyWords = mutableMapOf<String, Int>()

    words.forEach {
        if (it in frequencyWords) {
            frequencyWords[it] = frequencyWords[it]!! + 1
        } else {
            frequencyWords[it] = 1
        }
    }

    val maxFrequency = frequencyWords.values.max()
    val mostFrequentWords = frequencyWords.filter { it.value == maxFrequency }.keys

    return mostFrequentWords.minOf { it }
}