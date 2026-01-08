package com.lessons.fourth

import java.io.File


/*
Время = 0.535s
Память = 42.45Mb
*/
fun main() {
    val text = File("input.txt").readText().trim().split("\r\n")

    val shoppingList = mutableListOf<List<String>>()
    for (i in text) {
        shoppingList.add(i.split(" "))
    }

    val result = simulateBankingOperations(shoppingList)
    println(result)
}



fun simulateBankingOperations(operations: List<List<String>>) : String {

    val accounts = mutableMapOf<String, Int>()
    val output = mutableListOf<String>()

    for (operation in operations) {

        when (operation[0]) {
            "DEPOSIT" -> depositOperation(accounts, operation)
            "INCOME" -> incomeOperation(accounts, operation)
            "BALANCE" -> output.add(balanceOperation(accounts, operation))
            "WITHDRAW" -> withdrawOperation(accounts, operation)
            "TRANSFER" -> transferOperation(accounts, operation)
        }
    }

    return output.joinToString("\n")
}



fun depositOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) + operation[2].toInt()
}



fun withdrawOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) - operation[2].toInt()
}



fun transferOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) - operation[3].toInt()
    accounts[operation[2]] = accounts.getOrDefault(operation[2], 0) + operation[3].toInt()
}



fun incomeOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts.forEach { (name, sum) ->
        if (sum > 0) {
            accounts[name] = (sum * (100.0 + operation[1].toInt()) / 100.0).toInt()
        }
    }
}



fun balanceOperation(accounts: MutableMap<String, Int>, operation: List<String>) : String {

    return if (accounts.contains(operation[1])) {
        accounts[operation[1]].toString()
    } else {
        "ERROR"
    }
}