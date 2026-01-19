package com.lessons.fourth


/*
Время = 0.501s
Память = 32.12Mb

Сложность = O(K + N)
*/
fun main() {

    val n = readLine()!!.trim().toInt()
    val c = readLine()!!.trim().split(" ").map { it.toInt() }
    val k = readLine()!!.trim().toInt()
    val p = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = determinateKeyboardFailure(c, p)
    println(result)
}



fun determinateKeyboardFailure(c: List<Int>, p: List<Int>) : String {
    val clicks = mutableMapOf<Int, Int>()

    // O(K)
    // Определение числа нажатий
    p.forEach {
        // O(1)
        if (it in clicks) {
            clicks[it] = clicks[it]!! + 1
        } else {
            clicks[it] = 1
        }
    }

    val answers = mutableListOf<String>()

    // O(N)
    // Определение состояния клавиш
    c.forEachIndexed { index, value ->
        // O(1)
        if (clicks[index + 1]!! > value)
            answers.add("YES")
        else
            answers.add("NO")
    }

    // O(N)
    return answers.joinToString("\n")
}