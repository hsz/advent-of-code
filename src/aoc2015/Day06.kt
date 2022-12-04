package aoc2015

import mustBe
import permutation
import print
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

    fun List<String>.part1() = process { op ->
        when (op) {
            OP.ON -> 1
            OP.OFF -> 0
            OP.TOGGLE -> (this + 1) % 2
        }
    }

    fun List<String>.part2() = process { op ->
        when (op) {
            OP.ON -> this + 1
            OP.OFF -> (this - 1).coerceAtLeast(0)
            OP.TOGGLE -> this + 2
        }
    }

    listOf("turn on 0,0 through 999,999").part1() mustBe 1000000
    listOf("toggle 0,0 through 999,0").part1() mustBe 1000
    listOf("turn off 499,499 through 500,500").part1() mustBe 0

    listOf("turn on 0,0 through 0,0").part2() mustBe 1
    listOf("toggle 0,0 through 999,999").part2() mustBe 2000000

    readInput(2015, 6).apply {
        part1().print()
        part2().print()
    }
}
