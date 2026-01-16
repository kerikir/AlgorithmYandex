package com.lessons.first


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

    var floor1: Int = -1
    var entrance1: Int = -1

    // Перебор всех вариантов количества квартир на этаже
    for (apartmentsPerFloor in 1..< maxApartmentsPerFloor) {

        val (entranceCurrent, floorCurrent) =
            checkApartmentsPerFloor(apartment1, floors, apartment2, entrance2, floor2, apartmentsPerFloor)

        // Количество квартир на этаже подошло
        if (entranceCurrent != -1) {

            if (entrance1 == -1) {

                // Первое подходящее значение
                entrance1 = entranceCurrent
                floor1 = floorCurrent

            } else if ((entranceCurrent != entrance1) && (entrance1 != 0)) {

                // Несколько правильных решений
                entrance1 = 0

            } else if ((floorCurrent != floor1) && (floor1 != 0)) {

                // Несколько правильных решений
                floor1 = 0
            }
        }
    }

    return Pair(entrance1, floor1)
}



fun checkApartmentsPerFloor(
    apartment1: Int, floors: Int, apartment2: Int, entrance2: Int, floor2: Int, apartmentsPerFloor: Int
): Pair<Int, Int> {

    // Проверка на корректность значения количества квартир на этаже
    val (calculatedEntrance, calculatedFloor) = getEntranceAndFloor(apartment2, apartmentsPerFloor, floors)

    if (calculatedEntrance == entrance2 && calculatedFloor == floor2) {
        return getEntranceAndFloor(apartment1, apartmentsPerFloor, floors)
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