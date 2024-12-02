import java.time.chrono.JapaneseEra.values

fun main() {
    fun part1(input: List<String>): Int {
        var i = 0

        fun List<Int>.isSafe(): Boolean {
            if (size < 2) return false

            return isIncreasing(3) || isDecreasing(3)
        }

        input.forEach { input ->
            val values = input.split(" ").map(String::toInt)
            var safe = false

            values.forEachIndexed { idx, value ->
                if (safe) return@forEachIndexed

                val previous = values.getOrNull(idx - 1) ?: value

                if (diff(value, previous) <= 3 && values.isSafe()) {
                    i++
                    safe = true
                }
            }
        }

        return i
    }

    fun part2(input: List<String>): Int {
        var i = 0

        fun List<Int>.isSafe(): Boolean {
            if (size < 2) return false

            return isIncreasing(3) || isDecreasing(3)
        }

        input.forEach { input ->
            val values = input.split(" ").map(String::toInt)

            if (values.isSafe()) {
                i++
                return@forEach
            }

            for (idx in values.indices) {
                val modifiedValues = values.toMutableList()
                modifiedValues.removeAt(idx)

                if (modifiedValues.isSafe()) {
                    i++
                    break
                }
            }
        }

        return i
    }

    val input = readInput("day02")
    println(part1(input))
    println(part2(input))
}
