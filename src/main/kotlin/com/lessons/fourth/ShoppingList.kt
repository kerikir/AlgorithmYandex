package com.lessons.fourth

import java.io.File



fun main() {
    val text = File("input.txt").readText().trim().split("\r\n")

    val shoppingList = mutableListOf<Triple<String, String, Int>>()
    for (i in text) {
        val (name, item, count) = i.split(" ")
        shoppingList.add(Triple(name, item, count.toInt()))
    }

    val result = determinateShoppingList(shoppingList)
    println(result)
}



fun determinateShoppingList(shoppingList: List<Triple<String, String, Int>>) : String {

    var buyers = mutableMapOf<String, MutableMap<String, Int>>()

    for (item in shoppingList) {

        val bayer = buyers.getOrPut(item.first) { mutableMapOf() }

        bayer[item.second] = bayer.getOrDefault(item.second, 0) + item.third
    }

    buyers = buyers.toSortedMap()

    val list = mutableListOf<String>()
    for (item in buyers) {
        list.add("${item.key}:")

        for (i in item.value) {
            list.add("${i.key} ${i.value}")
        }
    }

    return list.joinToString("\n")
}