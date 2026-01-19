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
        symbolsInText[symbols[i]] = symbolsInText.getOrDefault(symbols[i], 0) + 1
    }

    println(symbolsInWord)
    println(symbolsInText)

    return 0
}