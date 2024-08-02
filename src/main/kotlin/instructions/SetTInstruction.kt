package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class SetTInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract the value to set to register T from the instruction
        val value = instruction.substring(1, 3).toInt(16)

        cpu.timer.value = value

        // Increment the program counter
        cpu.programCounter.increment()
    }
}