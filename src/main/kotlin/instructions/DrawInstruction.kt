package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class DrawInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu
        val screen = emulator.screen
        // Extract register indices from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val row = instruction[2].toString().toInt(16)
        val column = instruction[3].toString().toInt(16)

        // Get the byte value from the source register
        val value = cpu.registers[xRegisterIndex].toInt() and 0xFF

        // Check if the value is greater than 127 (0x7F)
        if (value > 0x7F) {
            throw IllegalArgumentException("Value in register is greater than 127")
        }

        // Ensure the row and column are within bounds
        if (row < 0 || row >= screen.height || column < 0 || column >= screen.width) {
            throw IllegalArgumentException("Row or column out of bounds")
        }

        // Convert the row and column to the address in the screen RAM
        val address = row * screen.width + column

        // Write the ASCII character to the screen's internal RAM
        screen.ram[address] = value.toUByte()

        // Display Screen
        screen.display()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}
