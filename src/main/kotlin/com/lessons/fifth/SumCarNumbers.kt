package com.lessons.fifth



fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val carNumbers = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateNumberOfSetCars(carNumbers, k)
    println(result)
}



fun determinateNumberOfSetCars(carNumbers: List<Int>, value: Int) : Int {

    var counter = 0

    var left = 0
    var right = 0

    var sum = 0

    // Подсчет наборов машин с нужными номерами
    while ((left < carNumbers.size) && (right < carNumbers.size)) {

        sum += carNumbers[right]

        while (sum > value && left <= right) {
            // Перебор суммы номеров
            sum -= carNumbers[left]
            left++
        }

        // Проверка соответствие суммы номеров
        if (sum == value) {
            counter++
        }

        right++
    }

    return counter
}