fun main() {

    fun part1(input: String) = input.lines().map(String::toInt).windowed(2).count { (a, b) -> a < b }

    fun part2(input: String) = input.lines().map(String::toInt).windowed(4) { it[3] > it[0] }.count { it }

    val testInput = readInput(2021, 1, true)
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput(2021, 1)
    println(part1(input))
    println(part2(input))
}
