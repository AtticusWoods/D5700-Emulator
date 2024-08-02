package instructionsTest

import org.example.Emulator
import org.example.instructions.ReadTInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

@OptIn(ExperimentalUnsignedTypes::class)
class ReadTInstructionTest {

    @Test
    fun testReadTInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Stop the timer to prevent it from ticking during the test
        cpu.timer.stop()

        // Set the value of register T
        cpu.timer.value = 0x0A

        // Create the ReadTInstruction instance
        val readTInstruction = ReadTInstruction()

        // Create an instruction string "C rX 00" where X is the register index
        val instruction = "C100"

        // Execute the instruction
        readTInstruction.execute(emulator, instruction)

        // Check if the value of register T was stored correctly in r0
        assertEquals(0x0A.toUByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}