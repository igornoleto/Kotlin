class Triangle(val a: Double, val b: Double, val c: Double) {

    constructor(a: Int, b: Int, c: Int) : this(a.toDouble(), b.toDouble(), c.toDouble())

    val isEquilateral: Boolean = a == b && b == c;
    val isIsosceles: Boolean = a == b && b != c;
    val isScalene: Boolean = a != b && b != c;

    init {
        require(a > 0 && b > 0 && c > 0) { "All sides must be greater than 0" }
        require(a + b >= c) { "This is not a Triangle! The sum of any two sides must be >=of the third side" }
    }

}

fun main(args: Array<String>) {

    println(Triangle(2, 2, 2).isEquilateral)
    println(Triangle(5, 5, 3).isIsosceles)
    println(Triangle(1, 2, 3).isScalene)
}
