package com.lessons.fourth


fun main() {
    val (g, s) = readLine()!!.trim().split(" ").map { it.toInt() }
    val w = readLine()!!.trim().map { it }
    val text = readLine()!!.trim()

    val result = decodeOfWriting(w, text)
    println(result)
}


fun decodeOfWriting(symbols: List<Char>, text: String) : Int {

    val symbolsInWord = mutableMapOf<Char, Int>()
    val symbolsInText = mutableMapOf<Char, Int>()

    // Символы и их количество в слове W
    for (symbol in symbols) {
        symbolsInWord[symbol] = symbolsInWord.getOrDefault(symbol, 0) + 1
    }

    // Получание символов и их количества в первом отрезке текста
    for (i in 0..symbols.lastIndex) {
        symbolsInText[text[i]] = symbolsInText.getOrDefault(text[i], 0) + 1
    }

    var counter = 0
    var degreeOfSimilarity = 0

    // Определение степени сходства с словом первого отрезка
    for (symbol in symbolsInWord) {
        if (symbol.value == symbolsInText[symbol.key]) {
            degreeOfSimilarity++
        }
    }

    // Проверка на сходство
    if (degreeOfSimilarity == symbolsInWord.size) {
        counter++
    }

    // Проверка степени сходства каждой последовательности
    for (i in symbols.size until text.length) {

        val leftSymbol = text[i - symbols.size]
        val nextSymbol = text[i]

        // Совпадающая буква ушла
        if (symbolsInWord[leftSymbol] == symbolsInText[leftSymbol]) {
            degreeOfSimilarity--
        }

        // Сдвиг левого указателя
        symbolsInText[leftSymbol] = (symbolsInText[leftSymbol] ?: 0) - 1
        // Сдвиг правого указателя
        symbolsInText[nextSymbol] = symbolsInText.getOrDefault(nextSymbol, 0) + 1

        // Нужная буква пришла
        if (symbolsInText[nextSymbol] == symbolsInWord[nextSymbol]) {
            degreeOfSimilarity++
        }

        // Проверка на сходство
        if (degreeOfSimilarity == symbolsInWord.size) {
            counter++
        }
    }

    return counter
}