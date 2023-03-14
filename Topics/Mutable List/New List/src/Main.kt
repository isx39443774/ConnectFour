fun solution(numbers: List<Int>, number: Int): MutableList<Int> {
    // put your code here
   var numbers1 = numbers.toMutableList()

    numbers1.add(number)

    return numbers1
}