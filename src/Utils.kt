import java.io.File
import java.math.BigInteger
import java.nio.file.Path
import java.security.MessageDigest
import kotlin.io.path.readLines

/**
 * Reads lines from the given input txt file.
 */
fun readInput(year: Int, day: Int, testData: Boolean = false) = Path.of("src")
    .resolve("aoc$year")
    .resolve("Day${"$day".padStart(2, '0')}${"_test".takeIf { testData }.orEmpty()}.txt")
    .readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5() = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray()))
    .toString(16)
    .padStart(32, '0')

/**
 * Returns a function that for the given parameter returns a value based on the provided [mapping] or [defaultValue] instead.
 */
fun <K, V> mapper(defaultValue: V, vararg mapping: Pair<K, V>): (K) -> V =
    { key -> mapOf(*mapping).getOrDefault(key, defaultValue) }

fun <K, P, V> mapper(defaultValue: (P) -> V, vararg mapping: Pair<K, (P) -> V>): (K, P) -> V =
    { key, param -> mapOf(*mapping).getOrDefault(key, defaultValue)(param) }

/**
 * Adds first and second values of two [Pair] instances to each others and returns another [Pair].
 */
operator fun Pair<Int, Int>.plus(p: Pair<Int, Int>) = first + p.first to second + p.second
operator fun Triple<Int, Int, Int>.plus(p: Triple<Int, Int, Int>) = Triple(first + p.first, second + p.second, third + p.third)

/**
 * Generates consecutive numbers until the given condition is satisfied.
 */
tailrec fun generateUntil(i: Int = 1, test: (Int) -> Boolean): Int = when {
    test(i) -> generateUntil(i + 1, test)
    else -> i
}

/**
 * Creates a sequence with a permutation of the two provided ranges.
 */
fun <T> Pair<Iterable<T>, Iterable<T>>.permutation() = sequence {
    this@permutation.first.forEach { x ->
        this@permutation.second.forEach { y ->
            yield(x to y)
        }
    }
}

/**
 * Creates a sequence with a permutation of the provided iterable.
 */
//fun <T> Iterable<T>.permutation() = (this to this).permutation()

/**
 * Shorthand for [String.toInt].
 */
operator fun String.unaryPlus() = toInt()

/**
 * Testing helper methods.
 */
infix fun Int.mustBe(value: Int) = check(this == value)
fun Int.print() = println(this)
