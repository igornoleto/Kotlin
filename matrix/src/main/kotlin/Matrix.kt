import java.util.Collections.list

class Matrix(private val matrixAsString: String) {

    val matrixTest = matrixAsString.split("\n").map { it.split(" ") }.map { it[0] }

    fun column(colNr: Int): List<Int> {
        val matrix = matrixAsString.split("\n").map {
            it.split(" ").map { it.toInt() }
        }

        return matrix.map { it[colNr - 1] }
    }

    fun row(rowNr: Int): List<String> {
        val matrix = matrixAsString.split("\n").map { it.split(" ") }

        return matrix[rowNr - 1]
    }

}


fun main(args: Array<String>) {

    println(Matrix("9 8 7\n5 3 2\n6 6 7").column(2))

    println(Matrix("9 8 7\n5 3 2\n6 6 7").row(1))
}
