import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    var balance = readln().toInt()
    var balance1 = balance
    var toPay = 0
    while (scanner.hasNextInt()) {
        // TODO
        val pay = scanner.nextInt()
        toPay += pay
        if (pay > balance1) {
            println("Error, insufficient funds for the purchase. Your balance is $balance1, but you need $pay.")

            break
        }

        balance1 -= pay
    }

    if (balance >= toPay) {
        println("Thank you for choosing us to manage your account! Your balance is ${balance - toPay}.")
    }
    // TODO

}