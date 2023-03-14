import java.util.Scanner

fun swapInts(ints: IntArray): IntArray {
    return intArrayOf(ints[1], ints[0])
}

fun main() {
    val scanner = Scanner(System.`in`)
    while (scanner.hasNextLine()) {
        var ints = intArrayOf(
            scanner.nextLine().toInt(),
            scanner.nextLine().toInt(),
        )
        val swaped = swapInts(ints)
        println(swaped[0])
        println(swaped[1])
    }
}