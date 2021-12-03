fun main() {
    fun part1(input: List<String>): Int {
        var x = 0
        var y = 0

        for (command in input) {
            val parts = command.split(" ")
            val direction = parts.first()
            val value = parts.last().toInt()

            when (direction) {
                "forward" -> x += value
                "up" -> y -= value
                "down" -> y += value
            }
        }

        return x * y
    }

    fun part2(input: List<String>): Int {
        var x = 0
        var y = 0
        var aim = 0

        for (command in input) {
            val parts = command.split(" ")
            val direction = parts.first()
            val value = parts.last().toInt()

            when (direction) {
                "forward" -> {
                    x += value
                    y += aim * value
                }
                "up" -> aim -= value
                "down" -> aim += value
            }
        }

        return x * y
    }

    // test part 1 example matches provided
    val testInput = readInput("Day02_test")
    check(part1(testInput) == 150)

    // solve part 1
    val input = readInput("Day02")
    println("Part 1 solution: ${part1(input)}")

    // test part 2 example matches provided
    check(part2(testInput) == 900)

    // solve part 2
    println("Part 2 solution: ${part2(input)}")
}