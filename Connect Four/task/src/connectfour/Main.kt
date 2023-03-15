package connectfour

fun main() {
    println("Connect Four")

    var (player1, player2) = getPlayers()

    val (rows, cols) = getBoardDimensions()

    val nGames = getNGames()

    printGameInfo(player1, player2, rows, cols)

    if (nGames > 1) {
        println("Total $nGames games")
    } else {
        println("Single Game")
    }

    var whichGame = 1

    var score = mutableListOf<Int>(0, 0)

    while (whichGame < nGames + 1) {
        var carPlayer1 = "o"
        var carPlayer2 = "*"
        var turn1 = true
        if (nGames > 1) {
            println("Game #$whichGame")
            if (whichGame % 2 == 0) {
                turn1 = false
            }
        }

        printBoard(rows, cols)

        val mut2DListBoard = mutableListOf<MutableList<String>>()

        for (row in 1..rows) {
            val mutRow = mutableListOf<String>()
            for (col in 1..cols) {
                mutRow.add(" ")
            }
            mut2DListBoard.add(mutRow)
        }


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
                            row[firstPlayerInput - 1] = carPlayer1
                            break
                        }
                    } else {
                        if (mut2DListBoard.reversed()[i - 1][firstPlayerInput - 1] != " " && mut2DListBoard.reversed()[i][firstPlayerInput - 1] == " ") {
                            row[firstPlayerInput - 1] = carPlayer1
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
                        break
                    }
                }
                if (draw) {
                    println("It is a draw")
                    score[0]++
                    score[1]++
                    println("Score")
                    println("$player1: ${score[0]} $player2: ${score[1]}")
                    break
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
                        if (car == carPlayer1) {
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
                        if (car == carPlayer1) {
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
                            if (i + 3 < matrixReversed.size && j - 3 >= 0 && matrixReversed[i][j] == carPlayer1 && matrixReversed[i + 1][j - 1] == carPlayer1 && matrixReversed[i + 2][j - 2] == carPlayer1 && matrixReversed[i + 3][j - 3] == carPlayer1) {
                                won1 = true
                                break
                            }
                        }
                    }
                }
                if (!won1) {
                    for (i in 0 until rows) {
                        for (j in 0 until cols - 3) {
                            if (i + 3 < matrixReversed.size && matrixReversed[i][j] == carPlayer1 && matrixReversed[i + 1][j + 1] == carPlayer1 && matrixReversed[i + 2][j + 2] == carPlayer1 && matrixReversed[i + 3][j + 3] == carPlayer1) {
                                won1 = true
                                break
                            }
                        }
                    }
                }
                if (won1) {
                    score[0] = score[0] + 2
                    println("Player $player1 won")
                    println("Score")
                    println("$player1: ${score[0]} $player2: ${score[1]}")
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


            if (mut2DListBoard[0][secondPlayerInput - 1] != " ") {
                println("Column $secondPlayerInput is full")
                continue
            }
            // add input player1 to our matrix
            var i = 0
            for (row in mut2DListBoard.reversed()) {
                if (i == 0) {
                    if (row[secondPlayerInput - 1] == " ") {
                        row[secondPlayerInput - 1] = carPlayer2
                        break
                    }
                } else {
                    if (mut2DListBoard.reversed()[i - 1][secondPlayerInput - 1] != " " && mut2DListBoard.reversed()[i][secondPlayerInput - 1] == " ") {
                        row[secondPlayerInput - 1] = carPlayer2
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
            var draw = true
            for (car in mut2DListBoard[0]) {
                if (car == " ") {
                    draw = false
                    continue
                }
            }
            if (draw) {
                println("It is a draw")
                score[0]++
                score[1]++
                println("Score")
                println("$player1: ${score[0]} $player2: ${score[1]}")
                break
            }
            // Winning Condition
            var won2 = false
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
                    if (car == carPlayer2) {
                        wHorizontal++

                    } else {
                        wHorizontal = 0

                    }
                    if (wHorizontal == 4) {
                        won2 = true
                        break
                    }
                    posCar++
                }
                posRow++
            }
            if (!won2) {
                var wVertical = 0
                for (car in listVertical) {
                    if (car == carPlayer2) {
                        wVertical++

                    } else {
                        wVertical = 0

                    }
                    if (wVertical == 4) {
                        won2 = true
                        break
                    }
                }
            }
            if (!won2) {
                for (i in 0 until rows) {
                    for (j in 1 until cols) {
                        if (i + 3 < matrixReversed.size && j - 3 >= 0 && matrixReversed[i][j] == carPlayer2 && matrixReversed[i + 1][j - 1] == carPlayer2 && matrixReversed[i + 2][j - 2] == carPlayer2 && matrixReversed[i + 3][j - 3] == carPlayer2) {
                            won2 = true
                            break
                        }
                    }
                }
            }
            if (!won2) {
                for (i in 0 until rows) {
                    for (j in 0 until cols - 3) {
                        if (i + 3 < matrixReversed.size && matrixReversed[i][j] == carPlayer2 && matrixReversed[i + 1][j + 1] == carPlayer2 && matrixReversed[i + 2][j + 2] == carPlayer2 && matrixReversed[i + 3][j + 3] == carPlayer2) {
                            won2 = true
                            break
                        }
                    }
                }
            }
            if (won2) {
                score[1] = score[1] + 2
                println("Player $player2 won")
                println(
                    "Score\n" +
                            "${player1}: ${score[0]} ${player2}: ${score[1]}"
                )
                break
            }

        }
        whichGame++
    }
    println("Game over!")
}

fun getNGames(): Int {
    var games = 1
    var badInput = true
    while (badInput) {
        println(
            "Do you want to play single or multiple games?\n" +
                    "For a single game, input 1 or press Enter"
        )
        println("Input a number of games:")
        val input = readln()

        if (input.isNotEmpty()) {
            if (input.toIntOrNull() != null) {
                val inputInt = input.toInt()
                if (inputInt > 0) {
                    games = inputInt
                    badInput = false
                } else {
                    println("Invalid Input")
                }
            } else {
                println("Invalid input")
            }
        } else {
            badInput = false
        }
    }

    return games
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









