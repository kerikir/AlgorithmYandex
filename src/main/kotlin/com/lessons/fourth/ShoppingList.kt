package com.lessons.fourth

import java.io.BufferedReader
import java.io.FileReader
import java.util.TreeMap


/*
Не решено - превышен лимит 1 сек
 */
fun main() {
    // В контесте неверный ответ из-за переполения, поэтому Long
    val buyers = TreeMap<String, TreeMap<String, Long>>()

    // В контесте только "\n"
    val text = BufferedReader(FileReader("input.txt"))

    text.useLines { lines ->

        lines.forEach { line ->
            if (line.isNotBlank()) {

                val (name, item, count) = line.split(" ")

                val bayer = buyers.getOrPut(name) { TreeMap() }
                bayer[item] = bayer.getOrDefault(item, 0L) + count.toLong()
            }
        }
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