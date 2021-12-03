package aoc2021

import readInput

fun main() {

    fun part1(input: List<String>) = input.map(String::toInt).windowed(2).count { (a, b) -> a < b }

    fun part2(input: List<String>) = input.map(String::toInt).windowed(4) { it[3] > it[0] }.count { it }

    val testInput = readInput("aoc2021/Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("aoc2021/Day01")
    println(part1(input))
    println(part2(input))
}
