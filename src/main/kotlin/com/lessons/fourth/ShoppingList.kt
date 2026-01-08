package com.lessons.fourth

import java.io.File


/*
Не решено
 */
fun main() {
    // В контесте только "\n"
    val text = File("input.txt").readText().trim().split("\r\n")

    val shoppingList = mutableListOf<Triple<String, String, Long>>()
    for (i in text) {
        val (name, item, count) = i.split(" ")
        shoppingList.add(Triple(name, item, count.toLong()))
    }

    val result = determinateShoppingList(shoppingList)
    println(result)
}



fun determinateShoppingList(shoppingList: List<Triple<String, String, Long>>) : String {

    // В контесте неверный ответ из-за переполения, поэтому Long
    val buyers = mutableMapOf<String, MutableMap<String, Long>>()

    for (item in shoppingList) {

        val bayer = buyers.getOrPut(item.first) { mutableMapOf() }

        bayer[item.second] = bayer.getOrDefault(item.second, 0L) + item.third
    }

    val list = mutableListOf<String>()
    for (item in buyers.toSortedMap()) {
        list.add("${item.key}:")

        for (i in item.value.toSortedMap()) {
            list.add("${i.key} ${i.value}")
        }
    }

    return list.joinToString("\n")
}