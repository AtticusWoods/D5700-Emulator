package instructionsTest

import org.example.CPU
import org.example.instructions.SkipNotEqualInstruction
import kotlin.test.Test
import kotlin.test.assertEquals

class SkipNotEqualInstructionTest {

    @Test
    fun testSkipNotEqualInstructionEqualRegisters() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize registers
        cpu.registers[1] = 0x5
        cpu.registers[2] = 0x5

        // Create the SkipEqualInstruction instance
        val skipNotEqualInstruction = SkipNotEqualInstruction()

        // Create an instruction string "3xy0" where x and y are register indices
        val instruction = "3120" // This means compare register 1 and register 2

        // Execute the instruction
        skipNotEqualInstruction.execute(cpu, instruction)

        // Check if the program counter was incremented correctly (by 2)
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testSkipNotEqualInstructionNotEqualRegisters() {
        // Create a CPU instance
        val cpu = CPU()

        // Initialize registers
        cpu.registers[1] = 0x5
        cpu.registers[2] = 0x3

        // Create the SkipEqualInstruction instance
        val skipNotEqualInstruction = SkipNotEqualInstruction()

        // Create an instruction string "3xy0" where x and y are register indices
        val instruction = "3120" // This means compare register 1 and register 2

        // Execute the instruction
        skipNotEqualInstruction.execute(cpu, instruction)

        // Check if the program counter was incremented correctly (by 4)
        assertEquals(4, cpu.programCounter.value)
    }
}