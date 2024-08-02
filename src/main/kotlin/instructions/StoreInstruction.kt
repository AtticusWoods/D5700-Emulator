package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class StoreInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract register indices and value from the instruction
        val registerIndex = instruction[1].toString().toInt(16)
        val byteVal = instruction.substring(2).toInt(16)

        // Store the result in the destination register (assuming the result fits in a byte)
        cpu.registers[registerIndex] = byteVal.toUByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}