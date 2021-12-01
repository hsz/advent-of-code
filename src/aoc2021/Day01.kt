package aoc2021

import readInput

fun main() {

    fun fn(input: List<String>, callback: Sequence<Int>.() -> Sequence<Int> = { this }) =
        input.asSequence().map(String::toInt).run(callback).windowed(2).count { (a, b) -> a < b }

    fun part1(input: List<String>) = fn(input)

    fun part2(input: List<String>) = fn(input) { windowed(3).map(List<Int>::sum) }

    val testInput = readInput("aoc2021/Day01_test")
    check(part1(testInput) == 7)
    check(part2(testInput) == 5)

    val input = readInput("aoc2021/Day01")
    println(part1(input))
    println(part2(input))
}
