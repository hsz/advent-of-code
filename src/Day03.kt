fun main() {

    val map = mapper(0 to 0, '^' to (0 to 1), '>' to (1 to 0), 'v' to (0 to -1), '<' to (-1 to 0))

    fun <T> String.process(initial: List<T>, callback: (acc: List<T>, Char) -> List<T>) = fold(initial, callback).distinct().size

    fun part1(input: String) = input.process(listOf(0 to 0)) { acc, c -> acc + (acc.last() + map(c)) }

    fun part2(input: String) = input.process(listOf(0 to 0, 0 to 0)) { acc, c -> acc + (acc[acc.size - 2] + map(c)) }

    part1(">") shouldBe 2
    part1("^>v<") shouldBe 4
    part1("^v^v^v^v^v") shouldBe 2

    part2("^v") shouldBe 3
    part2("^>v<") shouldBe 3
    part2("^v^v^v^v^v") shouldBe 11

    val input = readInput("Day03").first()
    println(part1(input))
    println(part2(input))
}
