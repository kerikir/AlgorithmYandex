package com.lessons.fourth


fun main() {

    val n = readLine()!!.trim().toInt()

    val dictionary = mutableMapOf<String, MutableSet<String>>()
    // Инициализация словаря
    for (i in 1..n) {

        // Ударение в слове
        val accent = readLine()!!.trim()
        // Исходное слово
        val word = accent.toLowerCase()

        if (word !in dictionary) {
            // Слова нет в словаре ударений
            dictionary[word] = mutableSetOf(accent)
        } else {
            // У слова несколько ударений
            dictionary[word]!!.add(accent)
        }
    }

    val text = readLine()!!.trim()

    val result = identificationOfErrorsInAccents(dictionary, text)
    println(result)
}


fun identificationOfErrorsInAccents(dictionary: Map<String, Set<String>>, text: String) : Int {

    var misstaces = 0

    return misstaces
}