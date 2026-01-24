package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val k = readLine()!!.trim().toInt()
    val operations = readLine()!!.trim()

    val result = definitionRobotAssemblyMethods(operations, k)
    println(result)
}



fun definitionRobotAssemblyMethods(operations: String, memory: Int) : Long {

    var currentLength = 0
    var numberOfWays = 0L

    // Пробег окном - двигаем указатель
    for (i in memory..operations.lastIndex) {

        if (operations[i] == operations[i - memory]) {
            // Экономически целесообразно использовать робота
            currentLength++
            numberOfWays += currentLength

        } else {
            // Операции записанные в памяти не повторяются
            currentLength = 0
        }
    }

    return numberOfWays
}