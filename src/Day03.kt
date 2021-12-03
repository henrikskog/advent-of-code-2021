fun main() {
    fun mostFrequent(str: String): Char {
        var a = str.count { it == '1' }
        var b = str.count { it == '0' }
        return if (a >= b) '1' else '0'
    }

    fun rebuildList(input: List<String>): MutableList<String> {
        val flippedList = mutableListOf<String>()
        val rows = input[0].length

        for (x in 0 until rows) {
            flippedList.add("")
        }


        for (i in input.indices) {
            for (j in input[i].indices) {
                flippedList[j] = flippedList[j] + (input[i][j])
            }
        }
        return flippedList
    }


    fun part1(input: List<String>): Int {
        var gammaRate = ""
        val flippedList = rebuildList(input)
        for (num in flippedList) {
            gammaRate += mostFrequent(num)
        }

        println(flippedList)
        println(gammaRate)

        var epsilonRate = gammaRate.replace("0", "x").replace("1", "0").replace("x", "1");
        var a1 = Integer.parseInt(epsilonRate, 2)
        var a2 = Integer.parseInt(gammaRate, 2)
        return a1 * a2
    }

    fun part2(input: List<String>): Int {
        var oxyRating = ""
        var CO2Rating = ""

        var oxyRatingList = input.map { it }.toMutableList()
        var CO2RatingList = input.map { it }.toMutableList()

        var oxyFound = false
        var co2Found = false

        for (colI in input[0].indices) {
            val common1 = mostFrequent(rebuildList(oxyRatingList)[colI])

            var x1 = 0
            while (x1 < oxyRatingList.size && !oxyFound) {
                if (oxyRatingList[x1][colI] != common1) {
                    oxyRatingList.removeAt(x1)
                    if (oxyRatingList.size == 1) {
                        oxyRating = oxyRatingList[0]
                        oxyFound = true
                        break
                    }
                } else x1 += 1
            }

            val common2 = mostFrequent(rebuildList(CO2RatingList)[colI])
            var x2 = 0
            while (x2 < CO2RatingList.size && !co2Found) {
                if (CO2RatingList[x2][colI] == common2) {
                    CO2RatingList.removeAt(x2)
                    if (CO2RatingList.size == 1) {
                        CO2Rating = CO2RatingList[0]
                        co2Found = true
                        break
                    }
                } else x2 += 1
            }

            if(oxyFound && co2Found) break
        }

        var a1 = Integer.parseInt(oxyRating, 2)
        var a2 = Integer.parseInt(CO2Rating, 2)
        println(a1)
        println(a2)
        return a1 * a2
    }

    val testInput = readInput("Day03")
    println(part2(testInput))

}
