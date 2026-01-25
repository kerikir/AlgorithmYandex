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
            val count = repeatChar.getOrDefault(string[right], 0) + 1
            repeatChar[string[right]] = count

            if (count <= maxRepeat) {
                // Подстрока продолжается
                currentLengthSubstring++

                if (currentLengthSubstring > maxLengthSubstring) {
                    // Нашли наибольшую подстроку
                    maxLengthSubstring = currentLengthSubstring
                    startIndexMaxLength = left + 1
                }

            } else {
                // Новый символ не подходит для подстроки
                break
            }

            right++
        }

        // Символ ушел из подстроки
        repeatChar[string[left]] = repeatChar.getOrDefault(string[left], 1) - 1
        currentLengthSubstring--
    }

    return maxLengthSubstring to startIndexMaxLength
}