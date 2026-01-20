package com.lessons.fourth

import java.io.File
import java.util.TreeMap


/*
Не решено - превышен лимит 1 сек
 */
fun main() {
    // В контесте только "\n"
    val text = File("input.txt").readText().trim().split("\r\n")  // O(L)

    // В контесте неверный ответ из-за переполения, поэтому Long
    val buyers = TreeMap<String, TreeMap<String, Long>>()

    for (i in text) {
        val (name, item, count) = i.split(" ")

        val bayer = buyers.getOrPut(name) { TreeMap() }
        bayer[item] = bayer.getOrDefault(item, 0L) + count.toLong()
    }

    val result = determinateShoppingList(buyers)
    println(result)
}



fun determinateShoppingList(buyers: TreeMap<String, TreeMap<String, Long>>) : String {

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