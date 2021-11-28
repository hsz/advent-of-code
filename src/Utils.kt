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

infix fun Int.shouldBe(expected: Int) {
    if (this != expected) throw AssertionError("$this != $expected")
}

/**
 * Provides a map
 */
fun <K, V> mapper(defaultValue: V, vararg mapping: Pair<K, V>): (K) -> V = { key -> mapOf(*mapping).getOrDefault(key, defaultValue) }

operator fun Pair<Int, Int>.plus(p: Pair<Int, Int>) = first + p.first to second + p.second
