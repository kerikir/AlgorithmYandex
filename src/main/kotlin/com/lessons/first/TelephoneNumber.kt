package com.lessons.first


/*
Время = 184ms
Память = 14.70Mb

Сложность = O(1)
 */
fun main() {
    val newNumber = readLine()!!.trim()

    val telephoneNumbers = mutableListOf<String>()
    for (i in 1..3) {
        telephoneNumbers.add(readLine()!!.trim())
    }

    // Нормализация введенного номера
    val newNumberNormalized = normalizeNumber(newNumber)
    for (number in telephoneNumbers) {
        // Нормализация номера
        val telephoneNumberNormalized = normalizeNumber(number)

        // Проверка на совпадение
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
    if (digitsOnly.length == 11 && (digitsOnly.startsWith('7') || digitsOnly.startsWith('8'))) {
        digitsOnly = digitsOnly.substring(1)
    }

    // Добавление кода города
    if (digitsOnly.length == 7) digitsOnly = "495$digitsOnly"

    return digitsOnly
}