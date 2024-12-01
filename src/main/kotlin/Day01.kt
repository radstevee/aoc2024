import kotlin.math.max
import kotlin.math.min

fun main() {
    val tripleSpace = " ".repeat(3) // just in case git decides to fuck me up

    fun part1(input: List<String>): Int {
        var i = 0
        val split = input.map { it.split(tripleSpace).map(String::toInt) }

        val left = split.map { it[0] }.sorted()
        val right = split.map { it[1] }.sorted()

        for (idx in 0 until left.size) {
            val l = left[idx]
            val r = right[idx]
            i += max(l, r) - min(l, r)
        }

        return i
    }

    fun part2(input: List<String>): Int {
        var i = 0
        val split = input.map { it.split(tripleSpace).map(String::toInt) }

        val left = split.map { it[0] }.sorted()
        val right = split.map { it[1] }.sorted()

        for (idx in 0 until left.size) {
            val l = left[idx]
            val occurrences = right.occurrences(l)

            i += l * occurrences
        }

        return i
    }

    val input = readInput("day01")

    println(part1(input))
    println(part2(input))
}
