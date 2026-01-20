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

    // Получение слов из текста
    val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }

    // Просмотр всех слов
    for (word in words) {

        val wordWithoutAccent = word.toLowerCase()

        if (wordWithoutAccent in dictionary) {
            // Есть ударение в словаре
            val right = dictionary[wordWithoutAccent]!!.contains(word)

            if (!right) {
                // Ошибка в ударении
                misstaces++
            }
        }
    }

    return misstaces
}