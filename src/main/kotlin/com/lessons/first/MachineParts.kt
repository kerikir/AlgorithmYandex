package com.lessons.first


/*
Время = 172ms
Память = 14.70Mb
 */
fun main() {
    val (n, k, m) = readLine()!!.trim().split(" ").map { it.toInt() }

    val result = calculateAmountMachineParts(n, k, m)
    println(result)
}


fun calculateAmountMachineParts(n: Int, consumptionBlank: Int, consumptionParts: Int) : Int {

    // Проверка на нехватку материала для изготовления
    if (
        n / consumptionBlank == 0 ||
        consumptionBlank / consumptionParts == 0
    ) {
        return 0
    }

    // Определение количества произведенных деталей за 1 загатовку
    val numberOfPartsFromBlank = consumptionBlank / consumptionParts
    // Остаток материала при изготовке деталей из 1 загатовки
    val remainOfPartsFromBlank = consumptionBlank - numberOfPartsFromBlank * consumptionParts

    // Определение количества деталей без повторного использования материала
    var numberOfDetails = (n / consumptionBlank) * numberOfPartsFromBlank
    // Определение остатка материала после изготовления деталей
    var remains = n % ((n / consumptionBlank) * consumptionBlank) +
            (n / consumptionBlank) * remainOfPartsFromBlank

    var amount: Int
    while (remains >= consumptionBlank) {
        amount = (remains / consumptionBlank) * numberOfPartsFromBlank
        numberOfDetails += amount

        remains = remains % ((remains / consumptionBlank) * consumptionBlank) +
                (remains / consumptionBlank) * remainOfPartsFromBlank
    }

    return numberOfDetails
}