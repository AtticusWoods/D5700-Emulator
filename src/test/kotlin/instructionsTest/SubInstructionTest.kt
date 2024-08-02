package instructionsTest

import org.example.Emulator
import org.example.instructions.SubInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

@OptIn(ExperimentalUnsignedTypes::class)
class SubInstructionTest {

    @Test
    fun testSubInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Initialize the registers
        cpu.registers[1] = 5u // xRegister
        cpu.registers[2] = 10u // yRegister

        // Create the SubInstruction instance
        val addInstruction = SubInstruction()

        // Create an instruction string "ABC" where A is the opcode, B is xRegister, C is yRegister, D is destination register
        val instruction = "1123" // subtract the value of register 1 and 2 and store in register 3

        // Execute the instruction
        addInstruction.execute(emulator, instruction)

        // Check if the result is correct
        assertEquals((-5).toUByte(), cpu.registers[3])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}