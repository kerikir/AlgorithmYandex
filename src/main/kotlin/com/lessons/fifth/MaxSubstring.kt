package com.lessons.fifth



/*
Время = 339ms
Память = 18.64Mb

Сложность = O(N + N) = O(N)
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val str = readLine()!!.trim()

    val result = determinateMaxSubstring(str, k)
    println("${result.first} ${result.second}")
}



fun determinateMaxSubstring(string: String, maxRepeat: Int) : Pair<Int, Int> {

    val repeatChar = mutableMapOf<Char, Int>()

    var maxLengthSubstring = 0
    var startIndexMaxLength = 0
    var currentLengthSubstring = 0

    var left = 0

    // Двигаем правый указатель - конец подстроки
    for (right in string.indices) {     // O(N)

        // Количество повторений буквы в подстроке
        val count = repeatChar.getOrDefault(string[right], 0) + 1
        repeatChar[string[right]] = count

        // Определяем максимальную подстроку для правого символа
        while (repeatChar[string[right]]!! > maxRepeat) {   // O(N)

            // Двигаем левый указатель - начало подстроки
            repeatChar[string[left]] = repeatChar.getOrDefault(string[left], 1) - 1
            left++
        }

        // Определение длины подстроки
        currentLengthSubstring = right - left + 1

        if (currentLengthSubstring > maxLengthSubstring) {  // O(1)
            // Нашли наибольшую подстроку
            maxLengthSubstring = currentLengthSubstring
            startIndexMaxLength = left + 1
        }
    }

    return maxLengthSubstring to startIndexMaxLength
}