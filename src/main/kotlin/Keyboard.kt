package org.example

class Keyboard {
    fun readInput(): String {
        println("Enter input: ")
        return readlnOrNull() ?: ""
    }
}
