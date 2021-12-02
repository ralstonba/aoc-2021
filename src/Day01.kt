fun main() {
    fun part1(input: List<String>): Int {
        return input
            .map { it.toInt() }
            .windowed(2)
            .map { it.last() > it.first() }.count { it }
    }

    fun part2(input: List<String>): Int {
        return input
            .asSequence()
            .map { it.toInt() }
            .windowed(3)
            .map { it ->  it.sum() }
            .windowed(2)
            .map { it.last() > it.first() }
            .count { it }
    }

    // test part 1 example matches provided
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 7)

    // solve part 1
    val input = readInput("Day01")
    println("Part 1 solution: ${part1(input)}")

    // test part 2 example matches provided
    check(part2(testInput) == 5)

    // solve part 2
    println("Part 2 solution: ${part2(input)}")
}
