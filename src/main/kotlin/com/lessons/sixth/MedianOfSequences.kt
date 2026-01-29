package com.lessons.sixth


fun main() {

    val (n, l) = readLine()!!.trim().split(' ').map { it.toInt() }

    val sequences = mutableListOf<IntArray>()
    repeat(n) {
        val sequence = readLine()!!.trim().split(' ').map { it.toInt() }.toIntArray()
        sequences.add(sequence)
    }
}