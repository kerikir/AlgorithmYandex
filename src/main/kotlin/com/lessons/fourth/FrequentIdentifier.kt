package com.lessons.fourth

import java.io.File
import java.util.LinkedHashMap


fun main() {
    val text = File("input.txt").readText().trim().split(Regex("\r\n"))

    val (n, c, d) = text[0].split(' ')

    // Чувствителен ли язык к регстру
    val caseSensitivity = c == "yes"
    // Может ли идентификатор начинаться с цифры
    val identifierWithDigit = d == "yes"
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

    val result = determinateMostFrequentIdentifier(program, keywords, caseSensitivity, identifierWithDigit)
    println(result)
}



fun determinateMostFrequentIdentifier(
    program: List<String>, keywords: Set<String>, caseSensitivity: Boolean, identifierWithDigit: Boolean
) : String {

    // Получение всех идентификаторов и ключевых слов в программе
    val words = program.joinToString("\n")
        .replace(Regex("[^A-Za-z0-9_]"), " ")
        .split(Regex("\\s+"))
        .filter { it.isNotBlank() }

    // Проверка на пустую программу
    if (words.isEmpty()) {
        return ""
    }

    val identifications = LinkedHashMap<String, Int>()

    // Пробег по всем словам
    for (word in words) {

        // Получение идентификатора в зависимости от специфики языка
        val identification = if (caseSensitivity) {
            word
        } else {
            word.toLowerCase()
        }

        // Не является ключевым словом
        if (identification !in keywords) {

            // Идентификатор не подходит
            if (identification.first().isDigit() && !identifierWithDigit) {
                // Первая цифра в идентификаторе и так запрещено в языке
                continue
            }
            if (identification.all { it.isDigit() }) {
                // Идентификатор состоит только из цифр
                continue
            }
            if (identification.all { it == '_' }) {
                // Идентификатор состоит только из символов подчеркивания
                continue
            }

            // Подсчет частоты идентификаторов
            val count = identifications.getOrDefault(identification, 0)
            identifications[identification] = count + 1
        }
    }

    if (identifications.isEmpty()) {
        return ""
    }

    // Максимальная частота повторения идентификатора
    val maxFrequency = identifications.maxOf { it.value }

    return identifications.entries.first { it.value == maxFrequency }.key
}