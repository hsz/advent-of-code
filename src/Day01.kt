fun main() {

    val map = mapper(-1, '(' to 1, 's' to 1)

    fun part1(input: String) = input.sumOf(map)

    fun part2(input: String) = input.foldIndexed(0) { index, acc, v ->
        (acc + map(v)).apply {
            if (this == -1) {
                return index + 1
            }
        }
    }

    part1("(())") shouldBe 0
    part1("(((") shouldBe 3
    part1("(()(()(") shouldBe 3
    part1("))(((((") shouldBe 3
    part1("())") shouldBe -1
    part1("))(") shouldBe -1
    part1(")))") shouldBe -3
    part1(")())())") shouldBe -3

    part2(")") shouldBe 1
    part2("()())") shouldBe 5

    val input = readInput("Day01").first()
    println(part1(input))
    println(part2(input))
}
