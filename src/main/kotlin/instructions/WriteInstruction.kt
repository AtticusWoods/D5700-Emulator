package org.example.instructions

import org.example.CPU

class WriteInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Extract the register index from the instruction
        val registerIndex = instruction[1].toString().toInt(16) // 2nd character is the register index
        val registerValue = cpu.registers[registerIndex]

        // Read the address from the special 16-bit address register 'A'
        val address = cpu.addressRegister

        // Write the value to memory
        if (cpu.memory.memoryFlag == 2) {
            // write ROM if memory flag M is 1
            // For Future proofing like assignment said
            cpu.memory.writeROM(address,registerValue)
        } else {
            // write RAM otherwise
            cpu.memory.write(address, registerValue)
        }

        // Increment the program counter
        cpu.programCounter.increment()
    }
}