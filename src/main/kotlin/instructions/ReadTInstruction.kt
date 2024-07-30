package org.example.instructions

import org.example.CPU

class ReadTInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract register index from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)

        // Read the value of register T and store it in the specified register
        cpu.registers[xRegisterIndex] = cpu.timer.value.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}