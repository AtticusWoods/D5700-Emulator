package org.example

import java.io.File

class Emulator {
    private val cpu = CPU()
    private val memory = cpu.memory
    private val programCounter = cpu.programCounter

    fun loadProgram(filePath: String) {
        val file = File(filePath)
        val programBytes = file.readBytes()
        System.arraycopy(programBytes, 0, memory.rom, 0, programBytes.size)
        memory.programSize = programBytes.size
    }

    fun run() {
        while (programCounter.value < memory.programSize) {
            val pc = programCounter.value
            val instructionBytes = cpu.memory.rom.sliceArray(pc until pc + 2)
            val instruction = instructionBytes.joinToString("") { "%02X".format(it) }
            if (instruction == "0000") break
            try {
                InstructionSet.execute(instruction, cpu)
            } catch (e: Exception) {
                println("Error executing instruction at address $pc: ${e.message}")
                break
            }
        }
        cpu.stop() // Stop the timer when the program completes
        println("Program has completed execution")
    }
}
