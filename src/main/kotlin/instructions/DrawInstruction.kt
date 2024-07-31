package org.example.instructions

import org.example.CPU

class DrawInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract register indices from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val yRegisterIndex = instruction[2].toString().toInt(16)
        val zRegisterIndex = instruction[3].toString().toInt(16)

        // Get the byte value from the source register
        val value = cpu.registers[xRegisterIndex].toInt() and 0xFF

        // Check if the value is greater than 127 (0x7F)
        if (value > 0x7F) {
            throw IllegalArgumentException("Value in register is greater than 127")
        }

        // Get the row and column from the specified registers
        val row = cpu.registers[yRegisterIndex].toInt() and 0xFF
        val column = cpu.registers[zRegisterIndex].toInt() and 0xFF

        // Convert the row and column to the address in the screen RAM
        val address = row * cpu.screen.width + column

        // Write the ASCII character to the screen's internal RAM
        cpu.screen.ram[address] = value.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}
