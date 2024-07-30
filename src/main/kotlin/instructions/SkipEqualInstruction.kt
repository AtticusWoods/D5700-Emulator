package org.example.instructions

import org.example.CPU

class SkipEqualInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
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