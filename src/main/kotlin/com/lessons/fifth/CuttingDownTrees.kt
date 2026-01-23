package com.lessons.fifth



/*
Время =
Память =
 */
fun main() {

    val (n, k) = readLine()!!.trim().split(' ').map { it.toInt() }
    val treesVarieties = readLine()!!.trim().split(' ').map { it.toInt() }

    val result = determinateMinLengthSegment(treesVarieties, k)
    println("${result.first} ${result.second}")
}



fun determinateMinLengthSegment(treesVariety: List<Int>, numberOfVarieties: Int) : Pair<Int, Int> {

    // Массив флагов вхождения в диапазон
    val varietiesNumberOfOccurrences = IntArray(numberOfVarieties)

    // Количество сортов на отрезке
    var counterVarieties = 0

    // Определение количества сортов на отрезке
    for (i in 0 until numberOfVarieties) {

        val currentVariety = treesVariety[i] - 1

        // Нет сорта на отрезке
        if (varietiesNumberOfOccurrences[currentVariety] == 0) {
            counterVarieties++
        }

        varietiesNumberOfOccurrences[currentVariety]++
    }

    var start = 1
    var finish = numberOfVarieties

    // На первом минимальном отрезке все сорта деревьев
    if (counterVarieties == numberOfVarieties) {

        return start to finish
    }

    var minLengthSegment = treesVariety.size
    var currentLengthSegment = treesVariety.size

    var left = 0
    var right = numberOfVarieties - 1

    // Перебор отрезков
    while (right < treesVariety.size && left < treesVariety.size) {

        val currentVariety = treesVariety[right] - 1

        // Нет сорта на отрезке
        if (varietiesNumberOfOccurrences[currentVariety] == 0) {
            counterVarieties++
        }

        varietiesNumberOfOccurrences[currentVariety]++

        // Все сорта есть на отрезке
        if (counterVarieties == numberOfVarieties) {

            currentLengthSegment = right - left

            // Наименьший по длине отрезок со всеми сортами
            if (currentLengthSegment < minLengthSegment) {
                minLengthSegment = currentLengthSegment
                start = left + 1
                finish = right + 1
            }

            // Пытаемся укоротить отрезок с левой стороны
            while (counterVarieties == numberOfVarieties) {

                // TODO проверка на выход за предел left и что left > right

                val leftVariety = treesVariety[left] - 1
                left++

                varietiesNumberOfOccurrences[leftVariety]--

                if (varietiesNumberOfOccurrences[leftVariety] == 0) {
                    // Необходимый сорт пропал
                    counterVarieties--

                } else {
                    // Отрезок успешно укоротился
                    currentLengthSegment = right - left

                    // Наименьший по длине отрезок со всеми сортами
                    if (currentLengthSegment < minLengthSegment) {
                        minLengthSegment = currentLengthSegment
                        start = left + 1
                        finish = right + 1
                    }
                }
            }
        }

        right++
    }

    return start to finish
}