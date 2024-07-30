package org.example.instructions

import org.example.CPU

class ReadKeyboardInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract the register index from the instruction
        val registerIndex = instruction[1].toString().toInt(16)

        // Pause the program and wait for keyboard input
        var input: String?
        do {
            input = cpu.keyboard.readInput()
        } while (input == null)

        if (input == "") input = "0"

        // Validate and parse the input
        val value = try {
            input.toInt(16)
        } catch (e: NumberFormatException) {
            throw IllegalArgumentException("Invalid input: Only base-16 digits (0-F) are allowed")
        }

        // Store the parsed number in the specified register
        cpu.registers[registerIndex] = value.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}
