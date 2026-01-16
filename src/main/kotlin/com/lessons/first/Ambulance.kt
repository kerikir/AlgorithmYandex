package com.lessons.first

import kotlin.math.max

/*
Не решено
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

    if (floor2 > floors) return Pair(-1, -1)

    // Нельзя определить число квартир на этаже (знаменатель == 0)
    if (entrance2 == 1 && floor2 == 1) {
        if (apartment2 == 1) {
            // Квартиры совпадают
            if (apartment1 == 1) return Pair(1, 1)

            // Номер квартиры меньше числа этажей
            val entrance1 = if (apartment1 <= floors) 1 else 0

            return Pair(entrance1, 0)
        }

        // Невозможно определить
        return Pair(0, 0)
    }

    // Максимально возможное количество квартир на этаже
    val maxApartmentsPerFloor = apartment2
    val apartmentsPerFloorSet = mutableSetOf<Int>()

    // Перебор всех вариантов количества квартир на этаже
    for (apartmentsPerFloor in 1..< maxApartmentsPerFloor) {


    }

    // Не нашли подходящих значений
    if (apartmentsPerFloorSet.isEmpty()) return Pair(-1, -1)

    var floor1: Int = -1
    var entrance1: Int = -1

    // Проверка каждого подходящего значения (число квартир на этаже)
    for (apartmentsPerFloor in apartmentsPerFloorSet) {

        // Количество квартир в подъезде
        val apartmentsPerEntrance = floors * apartmentsPerFloor

        // Определение номера подъезда
        val entranceCurrent = (apartment1 - 1) / apartmentsPerEntrance + 1 // Для краевых условий

        // Определение номера квартиры в подъезде
        val apartmentInEntrance = (apartment1 - 1) % apartmentsPerEntrance + 1 // Для краевых условий

        // Определение номера этажа
        val floorCurrent = (apartmentInEntrance - 1) / apartmentsPerFloor + 1 // Для краевых условий

        if (floorCurrent <= floors) {
            // Первое найденное значение
            if (entranceCurrent == -1) {
                entrance1 = entranceCurrent
                floor1 = floorCurrent
            } else if (entranceCurrent != entrance1 || floorCurrent != floor1) {
                // Несколько возможных ответов
                if (entrance1 != 0 && entranceCurrent != entrance1) entrance1 = 0
                if (floor1 != 0 && floorCurrent != floor1) floor1 = 0
            }
        }
    }

    // Решение не найдено
    if (floor1 == -1 || entrance1 == -1) {
        return Pair(-1, -1)
    }

    return Pair(entrance1, floor1)
}


fun checkApartmentsPerFloor()