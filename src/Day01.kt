fun main() {
    fun part1(input: List<String>): Int {
        var tot = 0
        for (i in 1 until input.size) {

            if (input[i].toInt() > input[i-1].toInt()) {
                tot += 1
            }
        }
        return tot
    }

    fun part2(input: List<String>): Int {
        val intInput = input.map{it.toInt()}

        var tot = 0

        // loop until third last index in list
        for (i in 1 until input.size-2) {
            val curr: Int = intInput.slice(i..i+2).sum()
            val prev: Int = intInput.slice(i-1..i+1).sum()
            if (curr > prev) tot += 1
        }
        return tot
    }

    val testInput = readInput("Day01_test")
    check(part2(testInput) == 5)

    val input = readInput("Day01")
    println(part2(input))
}
