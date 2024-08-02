package org.example.instructions

import org.example.Emulator

class ReadTInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu

        // Extract register index from the instruction
        val xRegisterIndex = instruction[1].toString().toInt(16)

        // Read the value of register T and store it in the specified register
        cpu.registers[xRegisterIndex] = cpu.timer.value.toByte()

        // Increment the program counter
        cpu.programCounter.increment()
    }
}