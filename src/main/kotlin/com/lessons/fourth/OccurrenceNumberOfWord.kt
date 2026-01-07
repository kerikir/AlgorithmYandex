package com.lessons.fourth


fun main() {
    val text = readLine()!!.trim()

    val result = determinateOccurrenceNumbersOfWords(text)
    println(result)
}



fun determinateOccurrenceNumbersOfWords(text: String) : String {

    val words = text.trim().replace("[\\s+]".toRegex(), " ").split(" ")

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