package org.example

import java.io.File

class Emulator {
    private val cpu = CPU()

    fun loadProgram(filePath: String) {
        val file = File(filePath)
        val programBytes = file.readBytes()
        System.arraycopy(programBytes, 0, cpu.memory.rom, 0, programBytes.size)
        cpu.memory.programSize = programBytes.size
    }

    fun run() {
        while (cpu.programCounter.value < cpu.memory.programSize) {
            val pc = cpu.programCounter.value
            val instructionBytes = cpu.memory.rom.sliceArray(pc until pc + 2)
            val instruction = instructionBytes.joinToString("") { "%02X".format(it) }

            try {
                InstructionSet.execute(instruction, cpu)
            } catch (e: Exception) {
                println("Error executing instruction at address $pc: ${e.message}")
                break
            }
        }
    }
}
