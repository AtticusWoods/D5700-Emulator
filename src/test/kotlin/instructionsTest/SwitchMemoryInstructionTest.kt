package instructionsTest

import org.example.CPU
import org.example.Emulator
import org.example.instructions.SwitchMemoryInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class SwitchMemoryInstructionTest {

    @Test
    fun testSwitchMemoryInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu
        val memory = emulator.memory

        // Initialize the memoryFlag to 0
        memory.memoryFlag = 0

        // Create the SwitchMemoryInstruction instance
        val switchMemoryInstruction = SwitchMemoryInstruction()

        // Create a 7 instruction string
        val instruction = "7000" // The instruction itself doesn't matter for this test

        // Execute the instruction (should switch memoryFlag to 1)
        switchMemoryInstruction.execute(emulator, instruction)
        assertEquals(1, memory.memoryFlag)
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)

        // Execute the instruction again (should switch memoryFlag to 0)
        switchMemoryInstruction.execute(emulator, instruction)
        assertEquals(0, memory.memoryFlag)
        // Check if the program counter was incremented correctly
        assertEquals(4, cpu.programCounter.value)
    }
}