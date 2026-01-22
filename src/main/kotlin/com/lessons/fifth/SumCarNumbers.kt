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

    var sum = carNumbers[0]

    // Подсчет наборов машин с нужными номерами
    while ((left < carNumbers.size) && (right < carNumbers.size)) {

        // Проверка соответствие суммы номеров
        if (sum == value) {
            counter++
        }

        // Двигаем указатели
        if (sum < value) {
            // Сумма номеров недостаточна
            sum += carNumbers[right]
            right++

        } else {
            // Перебор суммы номеров
            sum -= carNumbers[left]
            left++

            if (left > right) {
                right = left
            }
        }
    }

    return counter
}