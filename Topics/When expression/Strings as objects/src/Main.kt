fun main() {
    val input = readln()
    // write code here
    if (input.isNotEmpty()) {
        when (input.first()) {
            'i' -> println(input.drop(1).toInt() + 1)
            's' -> println(input.drop(1).reversed())
            else -> println(input)
        }
    } else {
        println("")
    }
}