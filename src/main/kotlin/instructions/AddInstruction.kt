package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class AddInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract register indices and value from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val yRegisterIndex = instruction[2].toString().toInt(16)
        val destinationRegisterIndex = instruction[3].toString().toInt(16)


        // Perform the addition
        val result = cpu.registers[xRegisterIndex] + cpu.registers[yRegisterIndex]

        // Store the result in the destination register (assuming the result fits in a byte)
        cpu.registers[destinationRegisterIndex] = result.toUByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}