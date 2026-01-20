package com.lessons.fourth

import java.io.File


fun main() {
    val text = File("input.txt").readText().trim().split(Regex("\r\n"))

    val (n, c, d) = text[0].split(' ')

    // Чувствителен ли язык к регстру
    val caseSensitivity = if (c == "yes") true else false
    // Может ли идентификатор начинаться с цифры
    val identifierWithDigit = if (d == "yes") true else false
    // Количество ключевых слов
    val numberOfKeywords = n.toInt()

    // Определение всех ключевых слов
    val keywords = mutableSetOf<String>()
    for (i in 1..numberOfKeywords) {

        val keyword = text[i]

        if (caseSensitivity) {
            keywords.add(keyword)

        } else {
            keywords.add(keyword.toLowerCase())
        }
    }

    // Получение кода программы
    val program = mutableListOf<String>()
    for (i in (numberOfKeywords + 1) until text.size) {
        program.add(text[i])
    }

    val result = determinateMostFrequentIdentifier()
    println(result)
}



fun determinateMostFrequentIdentifier() : String {
    return ""
}