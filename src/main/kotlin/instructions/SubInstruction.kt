package org.example.instructions

import org.example.CPU

class SubInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract register indices and value from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val yRegisterIndex = instruction[2].toString().toInt(16)
        val destinationRegisterIndex = instruction[3].toString().toInt(16)


        // Perform the addition
        val result = cpu.registers[xRegisterIndex] - cpu.registers[yRegisterIndex]

        // Store the result in the destination register (assuming the result fits in a byte)
        cpu.registers[destinationRegisterIndex] = result.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}