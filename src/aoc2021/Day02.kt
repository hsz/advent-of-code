package aoc2021

import mapper
import mustBe
import plus
import print
import readInput
import unaryPlus

fun main() {

    val map1 = mapper<String, Int, Pair<Int, Int>>(
        { 0 to 0 },
        "forward" to { it to 0 },
        "down" to { 0 to it },
        "up" to { 0 to -it },
    )

    fun List<String>.part1() = fold(0 to 0) { acc, value ->
        val (op, v) = value.split(' ')
        acc + map1(op, +v)
    }.let { it.first * it.second }

    val map2 = mapper<String, Pair<Int, Int>, Triple<Int, Int, Int>>(
        { Triple(0, 0, 0) },
        "forward" to { Triple(it.first, it.first * it.second, 0) },
        "down" to { Triple(0, 0, it.first) },
        "up" to { Triple(0, 0, -it.first) },
    )

    fun List<String>.part2() = fold(Triple(0, 0, 0)) { acc, value ->
        val (op, v) = value.split(' ')
        acc + map2(op, +v to acc.third)
    }.let { it.first * it.second }

    readInput(2021, 2, true).apply {
        part1() mustBe 150
        part2() mustBe 900
    }

    readInput(2021, 2).apply {
        part1().print()
        part2().print()
    }
}
