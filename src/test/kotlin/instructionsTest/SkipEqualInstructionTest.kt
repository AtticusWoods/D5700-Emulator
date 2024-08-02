package instructionsTest

import org.example.Emulator
import org.example.instructions.SkipEqualInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipEqualInstructionTest {

    @Test
    fun testSkipEqualInstructionEqualRegisters() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Initialize registers
        cpu.registers[1] = 0x5
        cpu.registers[2] = 0x5

        // Create the SkipEqualInstruction instance
        val skipEqualInstruction = SkipEqualInstruction()

        // Create an instruction string "3xy0" where x and y are register indices
        val instruction = "3120" // This means compare register 1 and register 2

        // Execute the instruction
        skipEqualInstruction.execute(emulator, instruction)

        // Check if the program counter was incremented correctly (by 4)
        assertEquals(4, cpu.programCounter.value)
    }

    @Test
    fun testSkipEqualInstructionNotEqualRegisters() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Initialize registers
        cpu.registers[1] = 0x5
        cpu.registers[2] = 0x3

        // Create the SkipEqualInstruction instance
        val skipEqualInstruction = SkipEqualInstruction()

        // Create an instruction string "3xy0" where x and y are register indices
        val instruction = "3120" // This means compare register 1 and register 2

        // Execute the instruction
        skipEqualInstruction.execute(emulator, instruction)

        // Check if the program counter was incremented correctly (by 2)
        assertEquals(2, cpu.programCounter.value)
    }
}