package org.example.instructions

import org.example.CPU

class ReadInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract the register index from the instruction
        val registerIndex = instruction[1].toString().toInt(16) // 2nd character is the register index

        // Read the address from the special 16-bit address register 'A'
        val address = cpu.addressRegister

        // Read the value from memory
        val value = if (cpu.memory.memoryFlag == 1) {
            // Read from ROM if memory flag M is 1
            cpu.memory.readROM(address)
        } else {
            // Read from RAM otherwise
            cpu.memory.read(address)
        }

        // Store the value in the specified register
        cpu.registers[registerIndex] = value

        // Increment the program counter
        cpu.programCounter.increment()
    }
}

