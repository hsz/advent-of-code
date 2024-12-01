fun main() {
    val map = mapper(0, true to 1)

    fun List<String>.process(vararg patterns: String) = sumOf {
        map(patterns.fold(true) { acc, v -> acc && v.toRegex().containsMatchIn(it) })
    }

    fun part1(input: String) = input.lines().process("""(.)\1""", """([aeiou].*){3}""", """^((?!ab|cd|pq|xy).)*$""")

    fun part2(input: String) = input.lines().process("""(..).*\1""", """(.).\1""")

    check(part1("ugknbfddgicrmopn") == 1)
    check(part1("aaa") == 1)
    check(part1("jchzalrnumimnmhp") == 0)
    check(part1("haegwjzuvuyypxyu") == 0)
    check(part1("dvszwmarrgswjxmb") == 0)

    check(part2("qjhvhtzxzqqjkmpb") == 1)
    check(part2("xxyxx") == 1)
    check(part2("uurcxstgmygtbstg") == 0)
    check(part2("ieodomkazucvgmuy") == 0)

    val input = readInput(2015, 5)
    println(part1(input))
    println(part2(input))
}
