fun main() {

    val map = mapper(0, true to 1)

    fun List<String>.process(vararg patterns: String) = sumOf {
        map(patterns.fold(true) { acc, v -> acc && v.toRegex().containsMatchIn(it) })
    }

    fun part1(input: List<String>) = input.process("""(.)\1""", """([aeiou].*){3}""", """^((?!ab|cd|pq|xy).)*$""")

    fun part2(input: List<String>) = input.process("""(..).*\1""", """(.).\1""")

    part1(listOf("ugknbfddgicrmopn")) shouldBe 1
    part1(listOf("aaa")) shouldBe 1
    part1(listOf("jchzalrnumimnmhp")) shouldBe 0
    part1(listOf("haegwjzuvuyypxyu")) shouldBe 0
    part1(listOf("dvszwmarrgswjxmb")) shouldBe 0

    part2(listOf("qjhvhtzxzqqjkmpb")) shouldBe 1
    part2(listOf("xxyxx")) shouldBe 1
    part2(listOf("uurcxstgmygtbstg")) shouldBe 0
    part2(listOf("ieodomkazucvgmuy")) shouldBe 0

    val input = readInput("Day05")
    println(part1(input))
    println(part2(input))
}
