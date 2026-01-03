package com.lessons.first

fun main() {
    val (apartament1, floors, apartament2, entrance2, floor2) =
        readLine()!!.trim().split(" ").map { it.toInt() }

    var floor1: Int
    var entrance1: Int


}


fun calculateApartament(
    apartament1: Int, floors: Int, apartament2: Int, entrance2: Int, floor2: Int
): Pair<Int, Int> {

    if (floor2 > floors) return Pair(-1, -1)

    // Нельзя определить число квартир на этаже (знаменатель == 0)
    if (entrance2 == 1 && floor2 == 1) {
        if (apartament2 == 1) {
            // Квартиры совпадают
            if (apartament1 == 1) return Pair(1, 1)

            // Минимум квартир в подъезде как этажей
            val entrance1 = if (apartament1 <= floors) 1 else 0
            // Минимум одна квартира на этаже
            val floor1 = if (apartament1 <= floors) apartament1 else 0
        }
    }

    // Количество этажей до 2 известной квартиры
    val denominator = (entrance2 - 1) * floors + (floor2 - 1)

}