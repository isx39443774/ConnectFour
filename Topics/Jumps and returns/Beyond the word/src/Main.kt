fun main() {
    // put your code here
    var word = readln()
    for (letter in 'a'..'z') {
        if (letter !in word){
            print(letter)
        }
    }

}