package org.example.instructions

import org.example.CPU

class SetAInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract the value to set to register A from the instruction
        val value = instruction.substring(1).toInt(16)

        // Set the value of register A
        cpu.addressRegister = value

        // Increment the program counter
        cpu.programCounter.increment()
    }
}
