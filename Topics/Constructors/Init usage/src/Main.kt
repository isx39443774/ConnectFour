fun main() {
    val timerValue = readln().toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(var time: Int) {
    init {
        if (time < -128) {
            time = -128
        } else if (time > 127) {
            time = 127
        }
    }
}