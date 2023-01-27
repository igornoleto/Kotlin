import kotlin.math.pow

class Squares {
    //TODO: implement proper constructor

    fun sumOfSquares(num: Int): Int {
        return ((1..num).sum().toDouble()).pow(2.0).toInt()
    }

    fun squareOfSum(num: Int): Int {
        val list = (1..num).toList();

        return list.sumOf { n -> n * n }
    }

    fun difference(number: Int): Int {
        val diff = sumOfSquares(number) - squareOfSum(number);

        println(diff)
        return diff
    }
}

fun main(args: Array<String>) {

    Squares().difference(10);
}
