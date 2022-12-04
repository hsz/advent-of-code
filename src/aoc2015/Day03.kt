package aoc2015

import mapper
import mustBe
import plus
import print
import readInput

fun main() {

    val map = mapper(0 to 0, '^' to (0 to 1), '>' to (1 to 0), 'v' to (0 to -1), '<' to (-1 to 0))

    fun <T> String.process(initial: List<T>, callback: (acc: List<T>, Char) -> List<T>) = fold(initial, callback).distinct().size

    fun String.part1() = process(listOf(0 to 0)) { acc, c -> acc + (acc.last() + map(c)) }

    fun String.part2() = process(listOf(0 to 0, 0 to 0)) { acc, c -> acc + (acc[acc.size - 2] + map(c)) }

    ">".part1() mustBe 2
    "^>v<".part1() mustBe 4
    "^v^v^v^v^v".part1() mustBe 2

    "^v".part2() mustBe 3
    "^>v<".part2() mustBe 3
    "^v^v^v^v^v".part2() mustBe 11

    readInput(2015, 3).first().apply {
        part1().print()
        part2().print()
    }
}
