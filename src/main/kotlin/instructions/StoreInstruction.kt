package org.example.instructions

import org.example.CPU

class StoreInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract register indices and value from the instruction
        val registerIndex = instruction[1].toString().toInt(16)
        val byteVal = instruction.substring(2).toInt(16)

        // Store the result in the destination register (assuming the result fits in a byte)
        cpu.registers[registerIndex] = byteVal.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}