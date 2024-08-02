package instructionsTest

import org.example.Emulator
import org.example.instructions.SetTInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SetTInstructionTest {

    @Test
    fun testSetTInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Create the SetTInstruction instance
        val setTInstruction = SetTInstruction()

        // Create an instruction string "Bbb0" where bb is the value to set in T
        val instruction = "B0A0" // This means set register T to 0x0A (or just A)

        // Execute the instruction
        setTInstruction.execute(emulator, instruction)

        // Check if the register T was set correctly
        assertEquals(0x0A, cpu.timer.value)
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

}