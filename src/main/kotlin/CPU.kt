package org.example

class CPU {
    val registers = ByteArray(8)
    val programCounter = ProgramCounter()
    val timer = Timer()
    val memory = Memory()
    val screen = Screen()
    val keyboard = Keyboard()
    val instructionSet = InstructionSet()

    fun executeInstruction(instruction: String) {
        instructionSet.execute(instruction, this)
    }
}
