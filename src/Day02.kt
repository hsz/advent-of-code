fun main() {

    fun process(input: List<String>, callback: (List<Int>) -> Int) = input.sumOf {
        it.split('x').map(String::toInt).sorted().let(callback)
    }

    fun part1(input: List<String>) = process(input) { (a, b, c) -> 3 * a * b + 2 * a * c + 2 * b * c }

    fun part2(input: List<String>) = process(input) { (a, b, c) -> 2 * a + 2 * b + a * b * c }

    check(part1(listOf("2x3x4")) == 58)
    check(part1(listOf("1x1x10")) == 43)

    check(part2(listOf("2x3x4")) == 34)
    check(part2(listOf("1x1x10")) == 14)

    val input = readInput("Day02")
    println(part1(input))
    println(part2(input))
}
