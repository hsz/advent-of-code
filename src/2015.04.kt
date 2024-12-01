fun main() {
    fun String.process(zeros: Int) = generateUntil {
        !"$this$it".md5().startsWith("0".repeat(zeros))
    }

    fun part1(input: String) = input.process(5)

    fun part2(input: String) = input.process(6)

    check(part1("abcdef") == 609043)
    check(part1("pqrstuv") == 1048970)

    val input = readInput(2015, 4)
    println(part1(input))
    println(part2(input))
}
