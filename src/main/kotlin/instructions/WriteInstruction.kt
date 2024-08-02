package org.example.instructions

import org.example.Emulator

class WriteInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Extract the register index from the instruction
        val registerIndex = instruction[1].toString().toInt(16) // 2nd character is the register index
        val registerValue = cpu.registers[registerIndex]

        // Read the address from the special 16-bit address register 'A'
        val address = cpu.addressRegister

        // Write the value to memory
        if (memory.memoryFlag == 1) {
            // write ROM if memory flag M is 1
            throw IllegalArgumentException("Cannot write to Rom")
            // For Future proofing like assignment said
            //cpu.memory.writeROM(address,registerValue)
        } else {
            // write RAM otherwise
            memory.write(address, registerValue)
        }

        // Increment the program counter
        cpu.programCounter.increment()
    }
}