package aoc2015

import mapper
import readInput

fun main() {

    val map = mapper(0, true to 1)

    fun List<String>.process(vararg patterns: String) = sumOf {
        map(patterns.fold(true) { acc, v -> acc && v.toRegex().containsMatchIn(it) })
    }

    fun part1(input: List<String>) = input.process("""(.)\1""", """([aeiou].*){3}""", """^((?!ab|cd|pq|xy).)*$""")

    fun part2(input: List<String>) = input.process("""(..).*\1""", """(.).\1""")

    check(part1(listOf("ugknbfddgicrmopn")) == 1)
    check(part1(listOf("aaa")) == 1)
    check(part1(listOf("jchzalrnumimnmhp")) == 0)
    check(part1(listOf("haegwjzuvuyypxyu")) == 0)
    check(part1(listOf("dvszwmarrgswjxmb")) == 0)

    check(part2(listOf("qjhvhtzxzqqjkmpb")) == 1)
    check(part2(listOf("xxyxx")) == 1)
    check(part2(listOf("uurcxstgmygtbstg")) == 0)
    check(part2(listOf("ieodomkazucvgmuy")) == 0)

    val input = readInput(2015, 5)
    println(part1(input))
    println(part2(input))
}
