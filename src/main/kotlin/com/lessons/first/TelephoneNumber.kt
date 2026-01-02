package com.lessons.first

/*
Не решено
 */
fun main() {
    val newNumber = readLine()!!

    val telephoneNumbers = mutableListOf<String>()
    for (i in 1..3) {
        telephoneNumbers.add(readLine()!!)
    }

    val newNumberNormalized = normalizeNumber(newNumber)
    for (number in telephoneNumbers) {
        val telephoneNumberNormalized = normalizeNumber(number)

        if (newNumberNormalized == telephoneNumberNormalized) {
            println("yes".toUpperCase())
        } else {
            println("no".toUpperCase())
        }
    }
}


fun normalizeNumber(phone: String) : String {
    // Удаляем все не цифры
    var digitsOnly = phone.replace(Regex("[^0-9]"), "")

    // Удаление кода страны
    if (digitsOnly.startsWith('7') || digitsOnly.startsWith('8')) {
        digitsOnly = digitsOnly.substring(1)
    }

    // Добавление кода города
    if (digitsOnly.length == 7) digitsOnly = "495$digitsOnly"

    return digitsOnly
}