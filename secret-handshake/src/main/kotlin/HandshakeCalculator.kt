object HandshakeCalculator {

    fun calculateHandshake(number: Int): List<Signal> {

        val signals = mutableListOf<Signal>()

        val binary = Integer.toBinaryString(number).toList().forEachIndexed { index, value ->
            when(index) {
                0 -> signals.add(Signal.WINK);
                1 -> signals.add(Signal.DOUBLE_BLINK)
                2 -> signals.add(Signal.CLOSE_YOUR_EYES)
                3 -> signals.add(Signal.JUMP)
                4 -> signals.reverse()
            }
        }

        return signals
    }
}

fun main(args: Array<String>) {


    println(HandshakeCalculator.calculateHandshake(30))
}
