package connectfour

fun main() {
    println("Connect Four")

    val (player1, player2) = getPlayers()

    val (rows, cols) = getBoardDimensions()

    printGameInfo(player1, player2, rows, cols)

    printBoard(rows, cols)


    val mut2DListBoard = mutableListOf<MutableList<String>>()

    for (row in 1..rows) {
        val mutRow = mutableListOf<String>()
        for (col in 1..cols) {
            mutRow.add(" ")
        }
        mut2DListBoard.add(mutRow)
    }

    var turn1 = true
    while (true) {
        if (turn1) {
            println("$player1's turn:")
            val firstPlayerInputStr = readln()

            // check input
            if (firstPlayerInputStr == "end") {
                println("Game over!")
                break
            } else if (firstPlayerInputStr.toIntOrNull() == null) {
                println("Incorrect column number")
                continue
            } else if (firstPlayerInputStr.toInt() !in 1..cols) {
                println("The column number is out of range (1 - $cols)")
                continue
            }
            //create matrix
            val firstPlayerInput = firstPlayerInputStr.toInt()
            var draw = true


            if (mut2DListBoard[0][firstPlayerInput - 1] != " ") {
                println("Column $firstPlayerInput is full")
                continue
            }
            // add input player1 to our matrix
            var i = 0
            for (row in mut2DListBoard.reversed()) {
                if (i == 0) {
                    if (row[firstPlayerInput - 1] == " ") {
                        row[firstPlayerInput - 1] = "o"
                        break
                    }
                } else {
                    if (mut2DListBoard.reversed()[i - 1][firstPlayerInput - 1] != " " && mut2DListBoard.reversed()[i][firstPlayerInput - 1] == " ") {
                        row[firstPlayerInput - 1] = "o"
                        break
                    }
                }
                i++
            }


            // print n columns
            for (col in 1..cols) {
                print(" $col")

            }
            println()
            // print board actualized

            for (row in 0 until rows) {
                var column = 0
                for (car in mut2DListBoard[row]) {
                    print("|")
                    column += 1
                    print(car)
                }
                print("|")
                println()
            }
            // Print linea final
            repeat(cols * 2 + 1) {
                print("=")
            }
            println()
            turn1 = false

            // Draw
            for (car in mut2DListBoard[0]) {
                if (car == " ") {
                    draw = false
                    continue
                }
            }
            if (draw) {
                println("It is a draw")
                println("Game Over!")
            }

            // Winning Condition
            var won1 = false
            var posRow = 0
            val matrixReversed = mut2DListBoard.reversed()
            var listVertical = mutableListOf<String>()

            // Winning Horizontal
            for (row in matrixReversed) {
                // Saving the position of every car of the column input, in a vertical position
                listVertical.add(row[firstPlayerInput - 1])

                var wHorizontal = 0
                var posCar = 0
                for (car in row) {
                    if (car == "o") {
                        wHorizontal++

                    } else {
                        wHorizontal = 0

                    }
                    if (wHorizontal == 4) {
                        won1 = true
                        break
                    }
                    posCar++
                }
                posRow++
            }
            if (!won1) {
                var wVertical = 0
                for (car in listVertical) {
                    if (car == "o") {
                        wVertical++

                    } else {
                        wVertical = 0

                    }
                    if (wVertical == 4) {
                        won1 = true
                        break
                    }
                }
            }
            if (!won1) {
                for (i in 0 until rows) {
                    for (j in 1 until cols) {
                        if (i + 3 < matrixReversed.size && j - 3 >= 0 && matrixReversed[i][j] == "o" && matrixReversed[i + 1][j - 1] == "o" && matrixReversed[i + 2][j - 2] == "o" && matrixReversed[i + 3][j - 3] == "o") {
                            won1 = true
                            break
                        }
                    }
                }
            }
            if (!won1) {
                for (i in 0 until rows) {
                    for (j in 0 until cols - 3) {
                        if (i + 3 < matrixReversed.size && matrixReversed[i][j] == "o" && matrixReversed[i + 1][j + 1] == "o" && matrixReversed[i + 2][j + 2] == "o" && matrixReversed[i + 3][j + 3] == "o") {
                            won1 = true
                            break
                        }
                    }
                }
            }
            if (won1) {
                println("Player $player1 won")
                println("Game Over!")
                break
            }


        }



        println("$player2's turn:")
        val secondPlayerInputStr = readln()

        if (secondPlayerInputStr == "end") {
            println("Game over!")
            break
        } else if (secondPlayerInputStr.toIntOrNull() == null) {
            println("Incorrect column number")
            continue
        } else if (secondPlayerInputStr.toInt() !in 1..cols) {
            println("The column number is out of range (1 - $cols)")
            continue
        }

        val secondPlayerInput = secondPlayerInputStr.toInt()

        var draw = true
        for (car in mut2DListBoard[0]) {
            if (car == " ") {
                draw = false
                break
            }
        }
        if (draw) {
            println("It is a draw")
            println("Game Over!")
        }

        if (mut2DListBoard[0][secondPlayerInput - 1] != " ") {
            println("Column $secondPlayerInput is full")
            continue
        }
        // add input player1 to our matrix
        var i = 0
        for (row in mut2DListBoard.reversed()) {
            if (i == 0) {
                if (row[secondPlayerInput - 1] == " ") {
                    row[secondPlayerInput - 1] = "*"
                    break
                }
            } else {
                if (mut2DListBoard.reversed()[i - 1][secondPlayerInput - 1] != " " && mut2DListBoard.reversed()[i][secondPlayerInput - 1] == " ") {
                    row[secondPlayerInput - 1] = "*"
                    break
                }
            }
            i++
        }
        // print n columns
        for (col in 1..cols) {
            print(" $col")

        }
        println()
        // print board actualized

        for (row in 0 until rows) {
            var column = 0
            for (car in mut2DListBoard[row]) {
                print("|")
                column += 1
                print(car)
            }
            print("|")
            println()
        }
        // Print linea final
        repeat(cols * 2 + 1) {
            print("=")
        }
        println()
        turn1 = true

        for (car in mut2DListBoard[0]) {
            if (car == " ") {
                draw = false
                break
            }
        }
        if (draw) {
            println("It is a draw")
            println("Game Over!")
        }
        // Winning Condition
        var won1 = false
        var posRow = 0
        val matrixReversed = mut2DListBoard.reversed()
        var listVertical = mutableListOf<String>()

        // Winning Horizontal
        for (row in matrixReversed) {
            // Saving the position of every car of the column input, in a vertical position
            listVertical.add(row[secondPlayerInput - 1])

            var wHorizontal = 0
            var posCar = 0
            for (car in row) {
                if (car == "*") {
                    wHorizontal++

                } else {
                    wHorizontal = 0

                }
                if (wHorizontal == 4) {
                    won1 = true
                    break
                }
                posCar++
            }
            posRow++
        }
        if (!won1) {
            var wVertical = 0
            for (car in listVertical) {
                if (car == "*") {
                    wVertical++

                } else {
                    wVertical = 0

                }
                if (wVertical == 4) {
                    won1 = true
                    break
                }
            }
        }
        if (!won1) {
            for (i in 0 until rows) {
                for (j in 1 until cols) {
                    if (i + 3 < matrixReversed.size && j - 3 >= 0 && matrixReversed[i][j] == "*" && matrixReversed[i + 1][j - 1] == "*" && matrixReversed[i + 2][j - 2] == "*" && matrixReversed[i + 3][j - 3] == "*") {
                        won1 = true
                        break
                    }
                }
            }
        }
        if (!won1) {
            for (i in 0 until rows) {
                for (j in 0 until cols - 3) {
                    if (i + 3 < matrixReversed.size && matrixReversed[i][j] == "*" && matrixReversed[i + 1][j + 1] == "*" && matrixReversed[i + 2][j + 2] == "*" && matrixReversed[i + 3][j + 3] == "*") {
                        won1 = true
                        break
                    }
                }
            }
        }
        if (won1) {
            println("Player $player2 won")
            println("Game Over!")
            break
        }

    }
}


fun printBoard(rows: Int, cols: Int) {
    for (col in 1..cols) {
        print(" $col")

    }
    println()
    for (row in 1..rows) {
        repeat(cols + 1) {
            print("| ")
        }
        println()

    }
    repeat(cols * 2 + 1) {
        print("=")
    }
    println()
}

fun getPlayers(): Pair<String, String> {
    print("First player's name:")
    val player1 = readln()

    print("Second player's name:")
    val player2 = readln()

    return Pair(player1, player2)
}

fun getBoardDimensions(): Pair<Int, Int> {
    var rows = 6
    var cols = 7

    while (true) {
        println("Set the board dimensions (Rows x Columns)\n" + "Press Enter for default (6 x 7)")
        val board = readln().replace("\\s".toRegex(), "")
        val regexBoard = Regex("^[0-9]?[0-9]?[0-9][xX][0-9]?[0-9]?[0-9]$")

        if (board.isEmpty()) {
            break
        }
        if (regexBoard.containsMatchIn(board)) {
            val (newRows, newCols) = board.split(Regex("[xX]")).map { it.toInt() }
            if (newRows in 5..9) {
                rows = newRows
                if (newCols in 5..9) {
                    cols = newCols
                } else {
                    println("Board columns should be from 5 to 9")
                }
            } else {
                println("Board rows should be from 5 to 9")
            }

            if (newRows in 5..9 && newCols in 5..9) {
                break
            }
        } else {
            println("Invalid input")
        }
    }

    return Pair(rows, cols)
}

fun printGameInfo(player1: String, player2: String, rows: Int, cols: Int) {
    println("$player1 VS $player2 \n$rows X $cols board")
}









