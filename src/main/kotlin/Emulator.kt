package org.example

import java.io.File

@kotlin.ExperimentalUnsignedTypes
class Emulator {
    val cpu = CPU()
    val memory = Memory()
    val screen = Screen()
    var keyboard = Keyboard()

    private val programCounter = cpu.programCounter


    fun loadProgram(filePath: String) {
        val file = File(filePath)
        val programBytes = file.readBytes().toUByteArray()
        for (i in programBytes.indices) {
            memory.rom[i] = programBytes[i]
        }
        memory.programSize = programBytes.size
    }

    fun run() {
        while (programCounter.value < memory.programSize) {
            val pc = programCounter.value
            val instructionBytes = memory.rom.sliceArray(pc until pc + 2)
            val instruction = instructionBytes.joinToString("") { "%02X".format(it.toInt()) }
            if (instruction == "0000") break
            try {
                InstructionSet.execute(instruction, this)
            } catch (e: Exception) {
                println("Error executing instruction at address $pc: ${e.message}")
                break
            }
        }
        cpu.stop() // Stop the timer when the program completes
        println("Program has completed execution")
    }
}
