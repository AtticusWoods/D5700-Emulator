package org.example

class Keyboard {
    fun readInput(): String? {
        // Simulating reading input from the keyboard
        println("Please enter a base-16 digit (0-F):")
        return readlnOrNull() ?: return "0";
    }
}
