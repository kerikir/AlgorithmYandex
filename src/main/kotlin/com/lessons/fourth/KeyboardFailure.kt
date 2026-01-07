package com.lessons.fourth


/*
Время = 0.501s
Память = 32.12Mb
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

    p.forEach {
        if (it in clicks) {
            clicks[it] = clicks[it]!! + 1
        } else {
            clicks[it] = 1
        }
    }

    val answers = mutableListOf<String>()
    c.forEachIndexed { index, value ->
        if (clicks[index + 1]!! > value)
            answers.add("YES")
        else
            answers.add("NO")
    }

    return answers.joinToString("\n")
}