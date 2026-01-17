package com.lessons.third


/*
Время = 0.912s
Память = 43.36Mb

Сложность = O(N * M)
 */
fun main() {
    val n = readLine()!!.trim().toInt()

    val languages = mutableListOf<MutableSet<String>>()
    for (i in 1..n) {
        val m = readLine()!!.trim().toInt()

        val lang = mutableSetOf<String>()
        for (j in 1..m) {
            lang.add(readLine()!!.trim())
        }

        languages.add(lang)
    }

    val everyStudent = determinateLanguagesEveryStudentKnows(languages)
    println(everyStudent.size)
    for (language in everyStudent) {
        println(language)
    }

    val leastOneStudent = determinateLanguagesLeastOneStudentKnows(languages)
    println(leastOneStudent.size)
    for (language in leastOneStudent) {
        println(language)
    }
}



/** Определение языков, который знает каждый студент */
fun determinateLanguagesEveryStudentKnows(languages: List<Set<String>>) : Set<String> {

    var languageEveryKnows = languages.first()

    // Пересечение всех множеств
    for (i in 1..languages.lastIndex) {
        languageEveryKnows = languageEveryKnows.intersect(languages[i])  // O(N * M)
    }

    return languageEveryKnows
}



/** Определение языков, который знает хотя бы один студент */
fun determinateLanguagesLeastOneStudentKnows(languages: List<Set<String>>) : Set<String> {

    var languageLeastOneKnows = mutableSetOf<String>()

    // Объединение всех множеств
    for (student in languages) {
        for (language in student) {
            languageLeastOneKnows.add(language) // O(N * M)
        }
    }

    return languageLeastOneKnows
}