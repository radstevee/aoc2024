import kotlin.io.path.Path
import kotlin.io.path.readText
import kotlin.math.min

/**
 * Reads lines from the given input txt file.
 */
fun readInput(name: String) = Path("src/inputs/$name.txt").readText().trim().lines()

fun <T> List<T>.occurrences(elem: T): Int {
    var i = 0
    forEach {
        if (it == elem) i++
    }

    return i
}

fun diff(a: Int, b: Int) = min(a, b) - min(a, b)

fun List<Int>.isIncreasing(maxDiff: Int): Boolean {
    if (this.size < 2) return true

    for (idx in 0 until this.size - 1) {
        if (this[idx] >= this[idx + 1] || (this[idx + 1] - this[idx]) > maxDiff) {
            return false
        }
    }
    return true
}

fun List<Int>.isDecreasing(maxDiff: Int): Boolean {
    if (this.size < 2) return true

    for (idx in 0 until this.size - 1) {
        if (this[idx] <= this[idx + 1] || (this[idx] - this[idx + 1]) > maxDiff) {
            return false
        }
    }
    return true
}
