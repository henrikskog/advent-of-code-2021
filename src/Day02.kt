fun main() {
    fun part1(input: List<String>): Int {
        var horizontal = 0
        var vertical = 0
        for (i in input) {
            val a = i.split(" ")
            when (a[0]) {
                "forward" -> horizontal += a[1].toInt()
                "down" -> vertical += a[1].toInt()
                "up" -> vertical -= a[1].toInt()
                else -> break
            }
        }
        return horizontal*vertical
    }

    fun part2(input: List<String>): Int {
        var horizontal = 0
        var vertical = 0
        var aim = 0
        for (i in input) {
            var a = i.split(" ")
            val x: Int = a[1].toInt()
            when (a[0]) {
                "forward" -> {
                    horizontal += x
                    vertical += aim * x
                }
                "down" -> aim += x
                "up" -> aim -= x
                else -> break
            }
        }
        return horizontal*vertical
    }

    val testInput = readInput("Day02_test")
    check(part2(testInput) == 900)

    val input = readInput("Day02")
    println(part2(input))
}
