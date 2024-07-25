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
            if (instruction == "break") break // todo figure out break point
            cpu.executeInstruction(instruction)
            cpu.timer.decrement()
            cpu.screen.render()
        }
    }
}
