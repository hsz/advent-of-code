package aoc2015

import mustBe
import print
import readInput

fun main() {

    fun List<String>.process(callback: (List<Int>) -> Int) = sumOf {
        it.split('x').map(String::toInt).sorted().let(callback)
    }

    fun List<String>.part1() = process { (a, b, c) -> 3 * a * b + 2 * a * c + 2 * b * c }

    fun List<String>.part2() = process { (a, b, c) -> 2 * a + 2 * b + a * b * c }

    listOf("2x3x4").part1() mustBe 58
    listOf("1x1x10").part1() mustBe 43

    listOf("2x3x4").part2() mustBe 34
    listOf("1x1x10").part2() mustBe 14

    readInput(2015, 2).apply {
        part1().print()
        part2().print()
    }
}
