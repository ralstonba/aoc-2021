fun main() {
    fun getMostCommon(input: List<String>): List<Char> {
        val ret = mutableListOf<Char>()

        // Break string input into list of chars: "00100" -> ['0', '0', '1', '0', '0']
        val charArr = input.map { it.toCharArray() }

        for (char in charArr.first().indices) {

            val counts = mutableMapOf<Char, Int>()

            for (lineItem in charArr.indices) {
                // Keep running sum of occurrences
                counts.merge(charArr[lineItem][char], 1) {prev, one -> prev + one}
            }

            val mostCommon = if (counts.getOrDefault('0', 0) > counts.getOrDefault('1', 0)) '0' else '1'

            ret.add(char, mostCommon)
        }

        return ret
    }

    fun flipBits(str: String): String {
        val charArray = str.toCharArray()
        val invertedArray = charArray.map { if (it == '0') '1' else '0' }
        return invertedArray.joinToString(separator = "")
    }

    fun part1(input: List<String>): Int {
        val mostCommon = getMostCommon(input)
        val gammaString = mostCommon.joinToString(separator = "")
        val epsilonString = flipBits(gammaString)

        println("Gamma: $gammaString")
        println("Epsilon: $epsilonString")

        return gammaString.toInt(2) * epsilonString.toInt(2)
    }

    fun part2(input: List<String>): Int {

        var temp = input
        var idx = 0
        while (temp.size > 1) {
            val mostCommon = getMostCommon(temp)
            temp = temp.filter { mostCommon[idx] == it[idx] }
            idx++
        }

        val oxygenRating = temp.first()

        temp = input
        idx = 0
        while (temp.size > 1) {
            val mostCommon = getMostCommon(temp)
            temp = temp.filter { mostCommon[idx] != it[idx] }
            idx++
        }

        val co2Rating = temp.first()

        return oxygenRating.toInt(2) * co2Rating.toInt(2)
    }

    // test part 1 example matches provided
    val testInput = readInput("Day03_test")
    check(part1(testInput) == 198)

    // solve part 1
    val input = readInput("Day03")
    println("Part 1 solution: ${part1(input)}")

    // test part 2 example matches provided
    check(part2(testInput) == 230)

    // solve part 2
    println("Part 2 solution: ${part2(input)}")
}