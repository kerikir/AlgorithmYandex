package com.lessons.fourth

import java.io.File


fun main() {
    val (n, c, d) = readLine()!!.trim().split(" ")

    // Чувствителен ли язык к регстру
    val caseSensitivity = if (c == "yes") true else false
    // Может ли идентификатор начинаться с цифры
    val identifierWithDigit = if (d == "yes") true else false
    // Количество ключевых слов
    val numberOfKeywords = n.toInt()

    val keywords = mutableSetOf<String>()

    // Определение всех ключевых слов
    for (i in 1..numberOfKeywords) {

        val keyword = readLine()!!.trim()

        if (caseSensitivity) {
            keywords.add(keyword)

        } else {
            keywords.add(keyword.toLowerCase())
        }
    }

    val program = mutableListOf<String>()
    while (true) {

        val line = readLine() ?: break
        program.add(line)
    }

    val result = determinateMostFrequentIdentifier()
    println(result)
}



fun determinateMostFrequentIdentifier() : String {
    return ""
}