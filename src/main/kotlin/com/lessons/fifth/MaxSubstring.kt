package com.lessons.fifth



/*
Время =
Память =
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

    var right = 0
    // Двигаем левый указатель - начало подстроки
    for (left in string.indices) {

        while (right < string.length) {

            // Количество повторений буквы в подстроке
            val count = repeatChar.getOrDefault(string[right], 0)

            if (count < maxRepeat) {
                // Подстрока продолжается
                repeatChar[string[right]] = count + 1

                currentLengthSubstring++

                if (currentLengthSubstring > maxLengthSubstring) {
                    // Нашли наибольшую подстроку
                    maxLengthSubstring = currentLengthSubstring
                    startIndexMaxLength = left
                }

            } else {
                // Новый символ не подходит для подстроки
                break
            }

            right++
        }

        // Символ ушел из подстроки
        repeatChar[string[left]] = repeatChar.getOrDefault(string[left], 1) - 1
    }

    return maxLengthSubstring to startIndexMaxLength
}