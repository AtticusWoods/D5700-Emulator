package instructionsTest

import org.example.CPU
import org.example.instructions.SetAInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SetAInstructionTest {

    @Test
    fun testSetAInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Create the SetAInstruction instance
        val setAInstruction = SetAInstruction()

        // Create an instruction string "Aaaa" where aaa is the value to set in A
        val instruction = "A255" // This means set register A to 0x255

        // Execute the instruction
        setAInstruction.execute(cpu, instruction)

        // Check if the A register was set correctly
        assertEquals(0x255, cpu.addressRegister)
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}