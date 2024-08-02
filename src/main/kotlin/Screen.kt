package org.example

@kotlin.ExperimentalUnsignedTypes
class Screen() {
    val width = 8
    val height = 8
    val ram: UByteArray = UByteArray(width * height)

    fun clear() {
        ram.fill(0u)
    }

    fun display() {
        println("========")
        for (row in 0 until height) {
            for (col in 0 until width) {
                val char = ram[row * width + col]
                if (char.toInt() == 0) {
                    print("█") // Empty space for 0 value
                } else {
                    print(char.toInt().toChar())
                }
            }
            println()
        }
        println("========")

    }
}
