package com.lessons.fourth

import java.io.BufferedReader
import java.io.FileReader
import java.util.TreeMap


/*
Время = 0.99s
Память = 58.72Mb

Сложность = O(L + N * logM + N * logK)
 */
fun main() {

    // Автоматическая сортировка при добавлении
    val buyers = TreeMap<String, TreeMap<String, Long>>()

    // Быстрое чтение в буфер
    val text = BufferedReader(FileReader("input.txt"))
    // O(L)
    text.useLines { lines ->

        // O(N)
        lines.forEach { line ->
            if (line.isNotBlank()) {

                val (name, item, count) = line.split(' ')   // O(S)

                val bayer = buyers.getOrPut(name) { TreeMap() }   // O(logM)
                // В контесте неверный ответ из-за переполения, поэтому Long
                bayer[item] = bayer.getOrDefault(item, 0L) + count.toLong()   // O(logK)
            }
        }
    }

    val result = determinateShoppingList(buyers)
    println(result)
}



fun determinateShoppingList(buyers: TreeMap<String, TreeMap<String, Long>>) : String {

    val result = StringBuilder()

    // Формирование ответа
    for ((name, items) in buyers) {     // O(N)

        result.append("$name:\n")

        for ((item, count) in items) {
            result.append("$item $count\n")
        }
    }

    return result.toString()
}