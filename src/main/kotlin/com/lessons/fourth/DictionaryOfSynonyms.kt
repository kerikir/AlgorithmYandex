package com.lessons.fourth


/*
Время = 0.642s
Память = 48.47Mb
*/
fun main() {

    val n = readLine()!!.trim().toInt()
    val words = mutableListOf<Pair<String, String>>()
    for (i in 1..n) {
        val (a, b) = readLine()!!.trim().split(" ")
        words.add(a to b)
    }
    val word = readLine()!!.trim()

    val result = determinateSynonym(words, word)
    println(result)
}



fun determinateSynonym(words: List<Pair<String, String>>, word: String) : String {
    val synonyms = mutableMapOf<String, String>()
    words.forEach {
        // Можно все слова положить в ключи и искать по ним
        synonyms.put(it.first, it.second)
    }

    var synonym = synonyms[word]

    if (synonym.isNullOrEmpty()) {
        synonym = synonyms.entries.find { it.value.equals(word) }?.key
    }

    return synonym ?: ""
}