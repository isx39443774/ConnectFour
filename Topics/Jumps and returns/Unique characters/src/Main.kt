fun main() {
    // put your code here
    val word = readln()
    var countSingleChars = 0

    for (letter in word) {
        var i = 0
        for (letter1 in word) {
            if (letter == letter1) {
                i ++
            }
        }
        if (i == 1) {
            countSingleChars ++
        }
    }
    println(countSingleChars)
}