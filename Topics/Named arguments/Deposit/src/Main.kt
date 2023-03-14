import kotlin.math.pow

fun main() {
    // write your code here

    val name = readln()
    val value = readln().toInt()
    when (name) {
        "amount" -> println(finalAmount(startingAmount = value))
        "percent" -> println(finalAmount(yearlyPercent = value))
        "years" -> println(finalAmount(deposit = value))
    }

}

fun finalAmount(startingAmount: Int = 1000, yearlyPercent: Int = 5, deposit: Int = 10): Int{
    return (startingAmount.toDouble() * (1 + yearlyPercent.toDouble() / 100.0).pow(deposit.toDouble())).toInt()
}