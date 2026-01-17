package com.lessons.first

import kotlin.math.max



/*
Время = 228ms
Память = 30.12Mb

Сложность = O(max(K1, K2))
 */
fun main() {
    val (apartment1, floors, apartment2, entrance2, floor2) =
        readLine()!!.trim().split(" ").map { it.toInt() }


    val (entrance1, floor1) = calculateApartment(apartment1, floors, apartment2, entrance2, floor2)
    println("$entrance1 $floor1")
}


fun calculateApartment(
    apartment1: Int, floors: Int, apartment2: Int, entrance2: Int, floor2: Int
): Pair<Int, Int> {

    if ((floor2 > floors) || (floors <= 0) || (apartment2 <= 0) ||
        (entrance2 <= 0) || (floor2 <= 0) || (apartment1 <= 0)
    ) {
        return Pair(-1, -1)
    }

    // Максимально возможное количество квартир на этаже
    // Дойдем если этаж или подъезд известной не равен 1
    val maxApartmentsPerFloor = max(apartment2, apartment1)

    var floor1: Int = -1
    var entrance1: Int = -1

    // Перебор всех вариантов количества квартир на этаже
    for (apartmentsPerFloor in 1.. maxApartmentsPerFloor) {

        val (entranceCurrent, floorCurrent) =
            checkApartmentsPerFloor(apartment1, floors, apartment2, entrance2, floor2, apartmentsPerFloor)

        // Количество квартир на этаже подошло
        if (entranceCurrent != -1) {

            if (entrance1 == -1) {

                // Первое подходящее значение
                entrance1 = entranceCurrent
                floor1 = floorCurrent

            } else {
                // Несколько решений

                if ((entranceCurrent != entrance1) && (entrance1 != 0)) {
                    // Несколько правильных решений
                    entrance1 = 0
                }

                if ((floorCurrent != floor1) && (floor1 != 0)) {
                    // Несколько правильных решений
                    floor1 = 0
                }
            }
        }
    }

    return if (floors == 1)
        Pair(entrance1, 1)
    else
        Pair(entrance1, floor1)
}



fun checkApartmentsPerFloor(
    apartment1: Int, floors: Int, apartment2: Int, entrance2: Int, floor2: Int, apartmentsPerFloor: Int
): Pair<Int, Int> {

    // Проверка на корректность значения количества квартир на этаже
    val (calculatedEntrance, calculatedFloor) = getEntranceAndFloor(apartment2, floors, apartmentsPerFloor)

    if (calculatedEntrance == entrance2 && calculatedFloor == floor2) {
        return getEntranceAndFloor(apartment1, floors, apartmentsPerFloor)
    } else {
        return -1 to -1
    }
}



fun getEntranceAndFloor(apartment: Int, floors: Int, apartmentsPerFloor: Int) : Pair<Int, Int> {

    // Количество квартир в подъезде
    val apartmentsPerEntrance = floors * apartmentsPerFloor

    // Определение номера подъезда
    val entranceCurrent = (apartment - 1) / apartmentsPerEntrance + 1

    // Определение номера квартиры в подъезде
    val apartmentInEntrance = (apartment - 1) % apartmentsPerEntrance + 1

    // Определение номера этажа
    val floorCurrent = (apartmentInEntrance - 1) / apartmentsPerFloor + 1

    return entranceCurrent to floorCurrent
}