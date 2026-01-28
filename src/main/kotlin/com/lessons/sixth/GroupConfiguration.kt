package com.lessons.sixth



/*
Время =
Память =
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
    growthSchoolchildren.sort()

    var leftBorder = 0
    // Максимальная разница в росте - разница между самым высоким учеником и самым низким
    var rightBorder = growthSchoolchildren[growthSchoolchildren.lastIndex] - growthSchoolchildren[0]

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

    return true
}