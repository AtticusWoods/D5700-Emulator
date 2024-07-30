package org.example.instructions

import org.example.CPU

class SetTInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract the value to set to register T from the instruction
        val value = instruction.substring(1, 3).toInt(16)

        // Ensure the value is within the 8-bit range
        cpu.timer.value = value
        println(value)

        // Increment the program counter
        cpu.programCounter.increment()
    }
}