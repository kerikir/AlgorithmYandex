package com.lessons.fourth

import java.io.File



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


    }

}



fun depositOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) + operation[2].toInt()
}



fun withdrawOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts[operation[1]] = accounts.getOrDefault(operation[1], 0) - operation[2].toInt()
}



fun incomeOperation(accounts: MutableMap<String, Int>, operation: List<String>) {

    accounts.forEach { name, sum ->
        if (sum > 0) {
            accounts[name] = (sum * (100.0 + operation[1].toInt())).toInt()
        }
    }
}



fun balanceOperation(accounts: MutableMap<String, Int>, operation: List<String>) : String {

    if (accounts.contains(operation[1])) {
        return accounts[operation[1]].toString()
    } else {
        return "ERROR"
    }
}