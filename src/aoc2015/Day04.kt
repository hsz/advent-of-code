package aoc2015

import generateUntil
import md5
import mustBe
import print
import readInput

fun main() {

    fun String.process(zeros: Int) = generateUntil { "$this$it".md5().length > 32 - zeros }

    fun String.part1() = process(5)

    fun String.part2() = process(6)

    "abcdef".part1() mustBe 609043
    "pqrstuv".part1() mustBe 1048970

    readInput(2015, 3).first().apply {
        part1().print()
        part2().print()
    }
}
