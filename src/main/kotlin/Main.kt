package org.example

@kotlin.ExperimentalUnsignedTypes
fun main() {
    val emulator = Emulator()

    println("Enter the path to the program file:")
    val filePath = readlnOrNull()

    if (!filePath.isNullOrEmpty()) {
        try {
            emulator.loadProgram(filePath)
            emulator.run()
        } catch (e: Exception) {
            println("Error: ${e.message}")
        }
    } else {
        println("Invalid file path")
    }
}
