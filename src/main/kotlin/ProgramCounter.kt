package org.example

class ProgramCounter {
    var value = 0

    fun increment() {
        value += 2
    }

    fun set(newValue: Int) {
        if (newValue % 2 == 0) value = newValue else throw IllegalArgumentException("Program counter must be even")
    }
}
