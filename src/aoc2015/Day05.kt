package aoc2015

import mapper
import mustBe
import print
import readInput

fun main() {

    val map = mapper(0, true to 1)

    fun List<String>.process(vararg patterns: String) = sumOf {
        map(patterns.fold(true) { acc, v -> acc && v.toRegex().containsMatchIn(it) })
    }

    fun List<String>.part1() = process("""(.)\1""", """([aeiou].*){3}""", """^((?!ab|cd|pq|xy).)*$""")

    fun List<String>.part2() = process("""(..).*\1""", """(.).\1""")

    listOf("ugknbfddgicrmopn").part1() mustBe 1
    listOf("aaa").part1() mustBe 1
    listOf("jchzalrnumimnmhp").part1() mustBe 0
    listOf("haegwjzuvuyypxyu").part1() mustBe 0
    listOf("dvszwmarrgswjxmb").part1() mustBe 0

    listOf("qjhvhtzxzqqjkmpb").part2() mustBe 1
    listOf("xxyxx").part2() mustBe 1
    listOf("uurcxstgmygtbstg").part2() mustBe 0
    listOf("ieodomkazucvgmuy").part2() mustBe 0

    readInput(2015, 5).apply {
        part1().print()
        part2().print()
    }
}
