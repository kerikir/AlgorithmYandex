package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val n = readLine()!!.trim().toInt()
    val a = readLine()!!.trim().split(' ').map { it.toInt() }

    val m = readLine()!!.trim().toInt()
    val infoAboutConditioners = mutableListOf<Pair<Int, Int>>()
    repeat(m) {
        val (b, c) = readLine()!!.trim().split(' ').map { it.toInt() }
        infoAboutConditioners.add(b to c)
    }

    val result = calculateCostConditioners(a, infoAboutConditioners)
    println(result)
}



fun calculateCostConditioners(
    requirementOfClasses: List<Int>, infoAboutConditioners: List<Pair<Int, Int>>
) : Int {

    // Сортировка классов по требованиям к кондиционеру
    val sortedClasses = requirementOfClasses.sorted()

    // Сортировка кондиционеров по стоимости
    val sortedConditioners = infoAboutConditioners.sortedBy { it.second }

    var conditionerPointer = 0
    var sumCost = 0

    // Сдвиг указателя на класс
    for (classPointer in sortedClasses.indices) {

        if (sortedClasses[classPointer] <= sortedConditioners[conditionerPointer].first) {
            // Кондиционер подходит для данного класса
            sumCost += sortedConditioners[conditionerPointer].second
            continue

        } else {
            // Не хватает мощности кондиционера для данного класса
            while (sortedClasses[classPointer] > sortedConditioners[conditionerPointer].first) {

                // Сдвиг указателя на кондиционер
                conditionerPointer++
            }

            sumCost += sortedConditioners[conditionerPointer].second
        }
    }

    return sumCost
}