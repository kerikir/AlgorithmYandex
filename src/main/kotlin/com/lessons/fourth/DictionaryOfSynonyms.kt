package com.lessons.fourth


/*
Время = 0.727s
Память = 48.93Mb
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
        synonyms.put(it.first, it.second)
        synonyms[it.second] = it.first
    }

    var synonym = synonyms[word]

    return synonym ?: ""
}