package com.lessons.sixth


/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }

    val arrayN = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
    val arrayK = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()

    val result = searchNumbersInArray(arrayN, arrayK)
    println(result)
}



fun searchNumbersInArray(arrayN: IntArray, arrayK: IntArray) : String {

    val resultList = mutableListOf<String>()

    // Проверка каждого числа на наличие в массиве
    for (number in arrayK) {

        val result = binarySearchNumber(arrayN, number)
        resultList.add(result)
    }

    return resultList.joinToString("\n")
}



fun binarySearchNumber(arrayN: IntArray, number: Int) : String {

    var leftBorder = 0
    var rightBorder = arrayN.lastIndex

    // Поиск первого элемента массива >= числу
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        if (arrayN[middle] >= number) {
            // Дальше все числа не подходят
            rightBorder = middle

        } else {
            // Все числа левее меньше нужного
            leftBorder = middle + 1
        }
    }

    return if (arrayN[leftBorder] == number) "YES" else "NO"
}