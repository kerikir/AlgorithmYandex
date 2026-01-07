package com.lessons.third



fun main() {
    val n = readLine()!!.trim().toInt()
    val languages = mutableListOf<MutableList<String>>()

    for (i in 1..n) {
        val m = readLine()!!.trim().toInt()

        val lang = mutableListOf<String>()
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



fun determinateLanguagesEveryStudentKnows(languages: List<List<String>>) : List<String> {

    var languageEveryKnows = languages[0].toSet()

    for (i in 1..languages.lastIndex) {
        val set = languages[i].toSet()
        languageEveryKnows = languageEveryKnows.intersect(set)
    }

    return languageEveryKnows.toList()
}



fun determinateLanguagesLeastOneStudentKnows(languages: List<List<String>>) : List<String> {

    var languageLeastOneKnows = languages[0].toSet()

    for (i in 1..languages.lastIndex) {
        val set = languages[i].toSet()
        languageLeastOneKnows = languageLeastOneKnows.union(set)
    }

    return languageLeastOneKnows.toList()
}