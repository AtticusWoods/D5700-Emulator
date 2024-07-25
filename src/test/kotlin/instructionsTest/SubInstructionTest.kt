package instructionsTest

import org.example.CPU
import org.example.instructions.SubInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SubInstructionTest {

    @Test
    fun testSubInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize the registers
        cpu.registers[1] = 5 // xRegister
        cpu.registers[2] = 10 // yRegister

        // Create the SubInstruction instance
        val addInstruction = SubInstruction()

        // Create an instruction string "ABC" where A is the opcode, B is xRegister, C is yRegister, D is destination register
        val instruction = "1123" // subtract the value of register 1 and 2 and store in register 3

        // Execute the instruction
        addInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals((-5).toByte(), cpu.registers[3])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}