package org.example.instructions

import org.example.Emulator

class SwitchMemoryInstruction : Instruction() {
    override fun execute(emulator: Emulator, instruction: String) {
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Toggle the memory Flag
        if (memory.memoryFlag == 0){
            memory.memoryFlag = 1
        }
        else if (memory.memoryFlag == 1) {
            memory.memoryFlag = 0
        }
        // Increment the program counter
        cpu.programCounter.increment()
    }
}