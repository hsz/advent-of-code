package aoc2021

import mustBe
import print
import readInput

fun main() {

    fun List<String>.part1() = map(String::toInt).windowed(2).count { (a, b) -> a < b }

    fun List<String>.part2() = map(String::toInt).windowed(4) { it[3] > it[0] }.count { it }

    readInput(2021, 1, true).apply {
        part1() mustBe 7
        part2() mustBe 5
    }

    readInput(2021, 1).apply {
        part1().print()
        part2().print()
    }
}
