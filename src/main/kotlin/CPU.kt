package org.example

class CPU {
    val registers = ByteArray(8) // General registers
    var addressRegister: Int = 0 // Special 16-bit address register 'A'
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
