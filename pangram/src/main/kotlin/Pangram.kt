object Pangram {

    fun isPangram(input: String): Boolean {
        val alphabet = ('a'..'z').toList();

        return alphabet.toCharArray().all { input.contains(it) }
    }
}

fun main() {

    println(Pangram.isPangram("hello")) //false
    println(Pangram.isPangram("The quick brown fox jumps over the lazy dog")) //true
}