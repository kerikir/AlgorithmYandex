package com.lessons.third



fun main() {
    val n = readLine()!!.trim().toInt()
    val languages = mutableSetOf<MutableSet<String>>()

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



fun determinateLanguagesEveryStudentKnows(languages: Set<Set<String>>) : Set<String> {

    var languageEveryKnows = languages.first()

    for (item in languages) {
        languageEveryKnows = languageEveryKnows.intersect(item)
    }

    return languageEveryKnows
}



fun determinateLanguagesLeastOneStudentKnows(languages: Set<Set<String>>) : Set<String> {

    var languageLeastOneKnows = languages.first()

    for (item in languages) {
        languageLeastOneKnows = languageLeastOneKnows.union(item)
    }

    return languageLeastOneKnows
}