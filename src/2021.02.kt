fun main() {

    val map1 = mapper<String, Int, Pair<Int, Int>>(
        { 0 to 0 },
        "forward" to { it to 0 },
        "down" to { 0 to it },
        "up" to { 0 to -it },
    )

    fun part1(input: String) = input.lines().fold(0 to 0) { acc, value ->
        val (op, v) = value.split(' ')
        acc + map1(op, +v)
    }.let { it.first * it.second }

    val map2 = mapper<String, Pair<Int, Int>, Triple<Int, Int, Int>>(
        { Triple(0, 0, 0) },
        "forward" to { Triple(it.first, it.first * it.second, 0) },
        "down" to { Triple(0, 0, it.first) },
        "up" to { Triple(0, 0, -it.first) },
    )

    fun part2(input: String) = input.lines().fold(Triple(0, 0, 0)) { acc, value ->
        val (op, v) = value.split(' ')
        acc + map2(op, +v to acc.third)
    }.let { it.first * it.second }

    val testInput = readInput(2021, 2, true)
    check(part1(testInput) == 150)
    check(part2(testInput) == 900)

    val input = readInput(2021, 2)
    println(part1(input))
    println(part2(input))
}
