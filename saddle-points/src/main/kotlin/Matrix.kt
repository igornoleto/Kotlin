class MatrixCoordinate(val matrixAsString: String) {

    val matrix: List<List<Int>> = matrixAsString.split("\n").map { it.split(" ").map { it.toInt() } }

    fun saddlePoints() {
        val rowsCols = mutableListOf<Pair<Int, Int>>()

        matrix.forEachIndexed { i, row ->
            row.forEachIndexed { j, actualNumber ->
                if (actualNumber == row.maxOrNull() && actualNumber == matrix.map { it[j] }.minOrNull()) {

                    rowsCols.add(Pair(i, j))
                    println("You Saddle Point is $actualNumber in row ${rowsCols.first().first} column ${rowsCols.first().second}")

                }
            }
        }
    }
}

fun main(args: Array<String>) {

    println(MatrixCoordinate("9 8 7\n5 3 2\n6 6 7").saddlePoints())
}


