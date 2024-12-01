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

    check(part1("(())") == 0)
    check(part1("(((") == 3)
    check(part1("(()(()(") == 3)
    check(part1("))(((((") == 3)
    check(part1("())") == -1)
    check(part1("))(") == -1)
    check(part1(")))") == -3)
    check(part1(")())())") == -3)

    check(part2(")") == 1)
    check(part2("()())") == 5)

    val input = readInput(2015, 1)
    println(part1(input))
    println(part2(input))
}
