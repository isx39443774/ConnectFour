fun polynomial(x: Int, c: Int, b: Int = 0, a: Int = 0): Int {
    if (a == 0) {
        if (b == 0) {
            return c
        } else {
            return b * x + c
        }
    } else {
        return a * x * x + b * x + c
    }

}