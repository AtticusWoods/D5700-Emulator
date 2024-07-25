package instructionsTest

import org.example.CPU

import org.example.instructions.StoreInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class StoreInstructionTest {

    @Test
    fun testStoreInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize the register
        cpu.registers[1] = 5 // xRegister

        // Create the AddInstruction instance
        val addInstruction = StoreInstruction()

        // Create an instruction string "ABC" where A is the opcode, B is xRegister, C is yRegister, D is destination register
        val instruction = "0123" // Store 35 (16*2 + 3) in register 1 to test if it replaces
        val instruction2 = "0310" //Store 16 in register 3 to test storing in empty register

        // Execute the instruction
        addInstruction.execute(cpu, instruction)
        addInstruction.execute(cpu, instruction2)

        // Check if the result is correct
        assertEquals(35.toByte(), cpu.registers[1])
        assertEquals(16.toByte(), cpu.registers[3])
        // Check if the program counter was incremented correctly
        assertEquals(4, cpu.programCounter.value)

    }
}