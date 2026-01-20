package com.lessons.fourth


/*
Время = 0.619s
Память = 44.18Mb

Сложность = O(N + L)
 */
fun main() {

    val n = readLine()!!.trim().toInt()

    val dictionary = mutableMapOf<String, MutableSet<String>>()
    // Инициализация словаря
    for (i in 1..n) {      // O(N * K)

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
    val words = text.split(Regex("\\s+")).filter { it.isNotBlank() }    // O(L)

    // Просмотр всех слов
    for (word in words) {    // O(M + K)

        val wordWithoutAccent = word.toLowerCase()

        // Проверка есть ли ударение в словаре
        if (wordWithoutAccent in dictionary) {

            val right = dictionary[wordWithoutAccent]!!.contains(word)

            if (!right) {
                // Ошибка в ударении
                misstaces++
            }

        } else {

            // Определение числа поставленных ударений
            val count = word.count { it.isUpperCase() }

            // Несколько поставленных ударений
            if (count != 1) {
                misstaces++
            }
        }
    }

    return misstaces
}