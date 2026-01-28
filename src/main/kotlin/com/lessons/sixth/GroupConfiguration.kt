package com.lessons.sixth



/*
Время = 479ms
Память = 31.12Mb

Сложность = O(N * logM + N * logN) = O(N * logN)
 */
fun main() {

    val (n, r, c) = readLine()!!.trim().split(' ').map { it.toInt() }

    val growthSchoolchildren = mutableListOf<Int>()
    repeat(n) {
        val growth = readLine()!!.trim().toInt()
        growthSchoolchildren.add(growth)
    }

    val result = determinateMaxHeightDifferenceInBrigade(growthSchoolchildren.toIntArray(), r, c)
    println(result)
}



fun determinateMaxHeightDifferenceInBrigade(
    growthSchoolchildren: IntArray, numberOfBrigade: Int, numberOfPeopleInBrigade: Int
) : Int {

    // Сортировка учеников по росту
    growthSchoolchildren.sort()     // O(N * logN)

    var leftBorder = 0
    // Максимальная разница в росте - разница между самым высоким учеником и самым низким
    var rightBorder = growthSchoolchildren[growthSchoolchildren.lastIndex] - growthSchoolchildren[0]

    // O(logM)
    while (leftBorder < rightBorder) {

        val middle = (rightBorder + leftBorder) / 2

        val isCorrect = checkCorrectHeightDifferenceInBrigade(middle,
            growthSchoolchildren, numberOfBrigade, numberOfPeopleInBrigade)

        if (isCorrect) {
            rightBorder = middle

        } else {
            leftBorder = middle + 1
        }
    }

    return leftBorder
}



fun checkCorrectHeightDifferenceInBrigade(
    heightDifference: Int, growthSchoolchildren: IntArray, numberOfBrigade: Int, numberOfPeopleInBrigade: Int
) : Boolean {

    var index = 0
    var numberOfBrigades = 0

    // Проверяем подходит ли бригада с минимальным ростом i школьника в группе
    while (index <= (growthSchoolchildren.size - numberOfPeopleInBrigade)) {    // O(N)

        // Определяем разницу в росте в текущей бригаде
        val currentHeightDifference = growthSchoolchildren[index + numberOfPeopleInBrigade - 1] -
                growthSchoolchildren[index]

        // Проверка подходит ли разница по требываемому удобству
        if (currentHeightDifference <= heightDifference) {

            numberOfBrigades++
            // Проверка следующей бригады
            index += numberOfPeopleInBrigade

        } else {
            // Проверка следующего школьника
            index++
        }
    }

    return numberOfBrigades >= numberOfBrigade
}