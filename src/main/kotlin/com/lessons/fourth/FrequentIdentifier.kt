package com.lessons.fourth

import java.io.File
import java.util.LinkedHashMap



/*
Время = 290ms
Память = 20.59Mb

Сложность = O(L + N * S + K)
 */
fun main() {

    val text = File("input.txt").readText().trim().split("\r\n")  // O(L)

    val (n, c, d) = text[0].split(' ')

    // Чувствителен ли язык к регстру
    val caseSensitivity = c == "yes"
    // Может ли идентификатор начинаться с цифры
    val identifierWithDigit = d == "yes"
    // Количество ключевых слов
    val numberOfKeywords = n.toInt()

    // Определение всех ключевых слов
    val keywords = mutableSetOf<String>()
    for (i in 1..numberOfKeywords) {   // O(M * S)

        val keyword = text[i]

        if (caseSensitivity) {
            keywords.add(keyword)

        } else {
            keywords.add(keyword.toLowerCase())
        }
    }

    // Получение кода программы
    val program = mutableListOf<String>()
    for (i in (numberOfKeywords + 1) until text.size) {   // O(L)
        program.add(text[i])
    }

    val result = determinateMostFrequentIdentifier(program, keywords, caseSensitivity, identifierWithDigit)
    println(result)
}



fun determinateMostFrequentIdentifier(
    program: List<String>, keywords: Set<String>, caseSensitivity: Boolean, identifierWithDigit: Boolean
) : String {

    // O(L + N)
    // Получение всех идентификаторов и ключевых слов в программе
    val words = program.joinToString("\n")
        .replace(Regex("[^A-Za-z0-9_]"), " ")
        .split(Regex("\\s+"))
        .filter { it.isNotBlank() }

    // Проверка на пустую программу
    if (words.isEmpty()) {
        return ""
    }

    val identifications = LinkedHashMap<String, Int>()  // O(1)

    // Пробег по всем словам
    for (word in words) {   // O(N)

        // Получение идентификатора в зависимости от специфики языка
        val identification = if (caseSensitivity) {
            word
        } else {
            word.toLowerCase()  // O(S)
        }

        // Не является ключевым словом
        if (identification !in keywords) {      // O(1)

            // Идентификатор не подходит
            if (identification.first().isDigit() && !identifierWithDigit) {
                // Первая цифра в идентификаторе и так запрещено в языке
                continue
            }
            if (identification.all { it.isDigit() }) {    // O(S)
                // Идентификатор состоит только из цифр
                continue
            }

            // Подсчет частоты идентификаторов
            val count = identifications.getOrDefault(identification, 0)    // O(1)
            identifications[identification] = count + 1                               // O(1)
        }
    }

    if (identifications.isEmpty()) {
        return ""
    }

    // Максимальная частота повторения идентификатора
    val maxFrequency = identifications.maxOf { it.value }   // O(K)

    return identifications.entries.first { it.value == maxFrequency }.key   // O(K)
}