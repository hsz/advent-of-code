import java.io.File
import java.math.BigInteger
import java.security.MessageDigest

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = File("src", "$name.txt").readLines()

/**
 * Converts string to md5 hash.
 */
fun String.md5(): String = BigInteger(1, MessageDigest.getInstance("MD5").digest(toByteArray())).toString(16)

/**
 * Throws an [AssertionError] exception if both sides of the comparison aren't equal.
 */
infix fun Int.shouldBe(expected: Int) {
    if (this != expected) throw AssertionError("$this != $expected")
}

/**
 * Returns a function that for the given parameter returns a value based on the provided [mapping] or [defaultValue] instead.
 */
fun <K, V> mapper(defaultValue: V, vararg mapping: Pair<K, V>): (K) -> V = { key -> mapOf(*mapping).getOrDefault(key, defaultValue) }

/**
 * Adds first and second values of two [Pair] instances to each others and returns another [Pair].
 */
operator fun Pair<Int, Int>.plus(p: Pair<Int, Int>) = first + p.first to second + p.second

/**
 * Generates consecutive numbers until the given condition is satisfied.
 */
tailrec fun generateUntil(i: Int = 1, test: (Int) -> Boolean): Int =
    if (test(i)) generateUntil(i + 1, test) else i
