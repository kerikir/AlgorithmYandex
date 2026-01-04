package com.lessons.first


fun main() {
    val (n, k, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = calculateAmountMachineParts(n, k, m)
    println(result)
}


fun calculateAmountMachineParts(n: Int, consumptionBlank: Int, consumptionParts: Int) : Int {

    // Определение количества деталей без повторного использования материала
    var numberOfDetails = (n / consumptionBlank) * (consumptionBlank / consumptionParts)
    // Определение остатка материала после изготовления деталей
    var remains = n % ((n / consumptionBlank) * consumptionBlank) +
            (n / consumptionBlank) * (consumptionBlank - (consumptionBlank / consumptionParts) * consumptionParts)

    var amount: Int
    while (remains >= consumptionBlank) {
        amount = (remains / consumptionBlank) * (consumptionBlank / consumptionParts)
        numberOfDetails += amount

        remains = remains % ((remains / consumptionBlank) * consumptionBlank) + (remains / consumptionBlank) *
                (consumptionBlank - (consumptionBlank / consumptionParts) * consumptionParts)
    }

    return numberOfDetails
}