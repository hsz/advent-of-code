import java.time.LocalDate
import kotlin.io.path.Path
import kotlin.io.path.readText

// Advent of Code – 2023.01
fun main() {
    val map = mapper(-1, '(' to 1, 's' to 1)

    fun part1(input: String) = input.trim().lines().sumOf {
        val first = it.first { c -> c.isDigit() }
        val last = it.last { c -> c.isDigit() }
        "$first$last".toInt()
    }

    fun part2(input: String) = input.trim().lines().sumOf {
        TODO()
        1.toInt()
    }

    check(part1("1abc2") == 12)
    check(part1("pqr3stu8vwx") == 38)
    check(part1("a1b2c3d4e5f") == 15)
    check(part1("treb7uchet") == 77)

    check(part2("two1nine") == 29)
    check(part2("eightwothree") == 83)
    check(part2("abcone2threexyz") == 13)
    check(part2("xtwone3four") == 24)
    check(part2("4nineeightseven2") == 42)
    check(part2("zoneight234") == 14)
    check(part2("7pqrstsixteen") == 76)

    val input = Path("src", "2023.01.txt").readText()
    println(part1(input))
}
