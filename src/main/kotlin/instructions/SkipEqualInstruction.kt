package org.example.instructions

import org.example.Emulator

class SkipEqualInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract register indices and value from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)
        val yRegisterIndex = instruction[2].toString().toInt(16)


        // Perform the comparison
        val result = cpu.registers[xRegisterIndex] == cpu.registers[yRegisterIndex]

        if (result) {
            // If equal increment counter
            cpu.programCounter.increment()
        }

        // Increment the program counter because all instructions do
        cpu.programCounter.increment()
    }
}