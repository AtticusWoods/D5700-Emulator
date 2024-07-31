package org.example

class Screen() {
    val width = 8
    val height = 8
    val ram: ByteArray = ByteArray(width * height)

    fun clear() {
        ram.fill(0)
    }

    fun drawCharacter(row: Int, col: Int, char: Byte) {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw IllegalArgumentException("Row or column out of bounds")
        }
        val address = row * width + col
        ram[address] = char
    }

    fun getCharacter(row: Int, col: Int): Byte {
        if (row < 0 || row >= height || col < 0 || col >= width) {
            throw IllegalArgumentException("Row or column out of bounds")
        }
        val address = row * width + col
        return ram[address]
    }

    fun display() {
        println("========")
        for (row in 0 until height) {
            for (col in 0 until width) {
                val char = ram[row * width + col]
                if (char.toInt() == 0) {
                    print("█") // Empty space for 0 value
                } else {
                    print(char.toChar())
                }
            }
            println()
        }
        println("========")

    }
}
