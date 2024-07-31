package org.example

class CPU {
    val registers = ByteArray(8) // General registers
    var addressRegister: Int = 0 // Special 16-bit address register 'A'
    val programCounter = ProgramCounter()
    val timer = Timer()
    val memory = Memory()
    val screen = Screen()
    var keyboard = Keyboard()
    val instructionSet = InstructionSet


    init {
        // Start the timer when the CPU is initialized
        timer.start()
    }

    fun stop() {
        // Stop the timer thread when the CPU is stopped
        timer.stop()
    }
}
