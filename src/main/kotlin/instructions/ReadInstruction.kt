package org.example.instructions

import org.example.Emulator

@kotlin.ExperimentalUnsignedTypes
class ReadInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Extract the register index from the instruction
        val registerIndex = instruction[1].toString().toInt(16) // 2nd character is the register index

        // Read the address from the special 16-bit address register 'A'
        val address = cpu.addressRegister

        // Read the value from memory
        val value = if (memory.memoryFlag == 1) {
            // Read from ROM if memory flag M is 1
            memory.readROM(address)
        } else {
            // Read from RAM otherwise
            memory.read(address)
        }

        // Store the value in the specified register
        cpu.registers[registerIndex] = value

        // Increment the program counter
        cpu.programCounter.increment()
    }
}

