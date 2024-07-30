package instructionsTest

import org.example.CPU
import org.example.instructions.ReadTInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test

class ReadTInstructionTest {

    @Test
    fun testReadTInstruction() {
        // Create a CPU instance
        val cpu = CPU()

        // Set the value of register T
        cpu.timer.value = 0x0A

        // Create the ReadTInstruction instance
        val readTInstruction = ReadTInstruction()

        // Create an instruction string "C rX 00" where X is the register index
        val instruction = "C000"

        // Execute the instruction
        readTInstruction.execute(cpu, instruction)

        // Check if the value of register T was stored correctly in r0
        assertEquals(0x0A.toByte(), cpu.registers[0])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }
}