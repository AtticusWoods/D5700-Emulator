package org.example.instructions

import org.example.CPU

class SwitchMemoryInstruction : Instruction() {
    override fun execute(cpu: CPU, instruction: String) {
        // Toggle the memory Flag
        if (cpu.memory.memoryFlag == 0){
            cpu.memory.memoryFlag = 1
        }
        else if (cpu.memory.memoryFlag == 1) {
            cpu.memory.memoryFlag = 0
        }
        // Increment the program counter
        cpu.programCounter.increment()
    }
}