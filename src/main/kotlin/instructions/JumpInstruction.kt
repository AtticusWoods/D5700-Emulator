package org.example.instructions

import org.example.CPU
import org.example.Emulator

class JumpInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract the address from the instruction
        val address = instruction.substring(1).toInt(16)

        // Check if the address is divisible by 2
        if (address % 2 != 0) {
            throw IllegalArgumentException("Address is not divisible by 2")
        }

        // Set the program counter to the address
        cpu.programCounter.value = address
    }
}