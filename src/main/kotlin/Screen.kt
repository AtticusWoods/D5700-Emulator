package org.example

class Screen {
    private val screenBuffer: Array<CharArray> = Array(8) { CharArray(8) { ' ' } } // 8x8 screen

    fun draw(row: Int, col: Int, char: Char) {
        if (row in 0 until 8 && col in 0 until 8) {
            screenBuffer[row][col] = char
        } else {
            throw IllegalArgumentException("Invalid screen coordinates")
        }
    }

    fun render() {
        for (row in screenBuffer) {
            println(row.joinToString(" "))
        }
    }
}
