package com.lessons.fourth

import java.io.File
import java.util.TreeMap


/*
Не решено - превышен лимит 1 сек
 */
fun main() {
    // В контесте только "\n"
    val text = File("input.txt").readText().trim().split("\r\n")  // O(L)

    val shoppingList = mutableListOf<Triple<String, String, Long>>()
    // O(N * S)
    for (i in text) {
        val (name, item, count) = i.split(" ")
        shoppingList.add(Triple(name, item, count.toLong()))
    }

    val result = determinateShoppingList(shoppingList)
    println(result)
}



fun determinateShoppingList(shoppingList: List<Triple<String, String, Long>>) : String {

    // В контесте неверный ответ из-за переполения, поэтому Long
    val buyers = TreeMap<String, TreeMap<String, Long>>()

    // Проход по всем покупкам
    for ((name, item, count) in shoppingList) {

        val bayer = buyers.getOrPut(name) { TreeMap() }

        bayer[item] = bayer.getOrDefault(item, 0L) + count
    }

    val result = StringBuilder()

    // Формирование ответа
    for ((name, items) in buyers) {

        result.append("$name:\n")

        for ((item, count) in items) {
            result.append("$item $count\n")
        }
    }

    return result.toString()
}