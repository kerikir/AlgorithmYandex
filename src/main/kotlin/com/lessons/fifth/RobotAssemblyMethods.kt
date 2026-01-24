package com.lessons.fifth



/*
Время = 271ms
Память = 18.05Mb
 */
fun main() {

    val k = readLine()!!.trim().toInt()
    val operations = readLine()!!.trim()

    val result = definitionRobotAssemblyMethods(operations, k)
    println(result)
}



fun definitionRobotAssemblyMethods(operations: String, memory: Int) : Long {

    var numberOfWays = 0L
    // Совпадения подряд
    var currentLength = 0

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