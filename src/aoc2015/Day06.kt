package aoc2015

import permutation
import readInput

enum class OP { ON, OFF, TOGGLE }

fun main() {

    fun List<String>.process(callback: Int.(OP) -> Int) =
        fold(mutableMapOf<Int, Int>()) { acc, v ->
            val op = OP.valueOf("on|off|toggle".toRegex().find(v)!!.value.uppercase())
            val (x1, y1, x2, y2) = v.replace("""\D+""".toRegex(), " ").trim().split(' ').map(String::toInt)

            (x1..x2 to y1..y2).permutation().fold(acc) { _, (x, y) ->
                (x * 1000 + y).apply {
                    acc[this] = callback(acc.getOrDefault(this, 0), op)
                }.let { acc }
            }
        }.values.sum()

    fun part1(input: List<String>) = input.process { op ->
        when (op) {
            OP.ON -> 1
            OP.OFF -> 0
            OP.TOGGLE -> (this + 1) % 2
        }
    }

    fun part2(input: List<String>) = input.process { op ->
        when (op) {
            OP.ON -> this + 1
            OP.OFF -> (this - 1).coerceAtLeast(0)
            OP.TOGGLE -> this + 2
        }
    }

    check(part1(listOf("turn on 0,0 through 999,999")) == 1000000)
    check(part1(listOf("toggle 0,0 through 999,0")) == 1000)
    check(part1(listOf("turn off 499,499 through 500,500")) == 0)

    check(part2(listOf("turn on 0,0 through 0,0")) == 1)
    check(part2(listOf("toggle 0,0 through 999,999")) == 2000000)

    val input = readInput("Day06")
    println(part1(input))
    println(part2(input))
}
