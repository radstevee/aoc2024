import kotlin.io.path.Path
import kotlin.io.path.readText

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
