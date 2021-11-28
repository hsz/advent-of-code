fun main() {

    fun String.process(zeros: Int) = generateUntil { "$this$it".md5().length > 32 - zeros }

    fun part1(input: String) = input.process(5)

    fun part2(input: String) = input.process(6)

    part1("abcdef") shouldBe 609043
    part1("pqrstuv") shouldBe 1048970

    val input = readInput("Day04").first()
    println(part1(input))
    println(part2(input))
}
