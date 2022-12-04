package aoc2015

import mapper
import mustBe
import print
import readInput

fun main() {

    val map = mapper(-1, '(' to 1, 's' to 1)

    fun String.part1() = sumOf(map)

    fun String.part2() = foldIndexed(0) { index, acc, v ->
        (acc + map(v)).apply {
            if (this == -1) {
                return index + 1
            }
        }
    }

    "(())".part1() mustBe 0
    "(((".part1() mustBe 3
    "(()(()(".part1() mustBe 3
    "))(((((".part1() mustBe 3
    "())".part1() mustBe -1
    "))(".part1() mustBe -1
    ")))".part1() mustBe -3
    ")())())".part1() mustBe -3

    ")".part2() mustBe 1
    "()())".part2() mustBe 5

    readInput(2015, 1).first().apply {
        part1().print()
        part2().print()
    }
}
