package instructionsTest

import org.example.CPU
import org.example.instructions.AddInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test


class AddInstructionTest {

    @Test
    fun testAddInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize the registers
        cpu.registers[1] = 5 // xRegister
        cpu.registers[2] = 10 // yRegister

        // Create the AddInstruction instance
        val addInstruction = AddInstruction()

        // Create an instruction string "ABC" where A is the opcode, B is xRegister, C is yRegister, D is destination register
        val instruction = "1123" // This means add the value of register 1 and 2 and store in register 3

        // Execute the instruction
        addInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(15.toByte(), cpu.registers[3])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}
