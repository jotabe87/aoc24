fun main() {

    fun getInputLists(input: List<String>): Pair<MutableList<Int>, MutableList<Int>> {
        val list1 = mutableListOf<Int>()
        val list2 = mutableListOf<Int>()

        for (i in input) {
            val line = i.split("   ")
            list1.add(line[0].toInt())
            list2.add(line[1].toInt())
        }
        return Pair(list1, list2)
    }

    fun part1(input: List<String>): Int {
        val (list1, list2) = getInputLists(input)

        val distances = mutableListOf<Int>()

        list1.sorted().forEachIndexed { index, element1 ->
            val element2 = list2.sorted()[index]
            var distance = element1 - element2
            if (distance.isNegative()) {
                distance *= -1
            }
            distances.add(distance)
        }

        return distances.sum()
    }

    fun part2(input: List<String>): Int {
        val (list1, list2) = getInputLists(input)

        val similarities = mutableListOf<Int>()

        list1.forEach { element ->
            val similarityScore = list2.count { it == element }
            similarities.add(element * similarityScore)
        }

        return similarities.sum()
    }

    // Or read a large test input from the `src/Day01_test.txt` file:
    val testInput = readInput("Day01_test")
    check(part1(testInput) == 11)

    // Read the input from the `src/Day01.txt` file.
    val input = readInput("Day01")
    part1(input).println()
    part2(input).println()
}

fun Int.isNegative() = this < 0