package org.example.instructions

import org.example.CPU

class ConvertByteToAsciiInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract register indices and value from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val yRegisterIndex = instruction[2].toString().toInt(16)

        // convert rX to ascii value
        val value = cpu.registers[xRegisterIndex].toInt()

        // Check if the value is greater than F
        if (value > 0xF) {
            throw IllegalArgumentException("Value in register is greater than F")
        }

        // Convert the value to its ASCII representation
        val asciiValue = if (value < 10) {
            '0'.code + value // '0' to '9'
        } else {
            'A'.code + (value - 10) // 'A' to 'F'
        }

        // Store the result in the destination register (assuming the result fits in a byte)
        cpu.registers[yRegisterIndex] = asciiValue.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}