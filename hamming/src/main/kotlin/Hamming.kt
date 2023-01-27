object Hamming {

    fun compute(dna1: String, dna2: String): Int {
        val zipping = dna1.zip(dna2)
        println(zipping)

        if (dna1.length != dna2.length) {
            println("The length must be equal!")
        }
        return dna1.zip(dna2).count { it.first != it.second };
    }

}
