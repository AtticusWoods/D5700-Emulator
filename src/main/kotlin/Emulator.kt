package org.example

class Emulator {
    val cpu = CPU()

    fun loadProgram(filePath: String) {
        // Load the program into Memory (ROM)
    }

    fun run() {
        while (true) {
            val address = cpu.programCounter.value
            val instruction = "${cpu.memory.read(address)}${cpu.memory.read(address + 1)}"
            if (instruction == "00") break // Assuming 0000 is the stop instruction
            cpu.executeInstruction(instruction)
            cpu.timer.decrement()
            cpu.screen.render()
        }
    }
}
