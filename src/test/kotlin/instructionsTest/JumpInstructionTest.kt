package instructionsTest

import org.example.CPU
import org.example.instructions.JumpInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import kotlin.test.Test
import kotlin.test.assertFailsWith

class JumpInstructionTest {

    @Test
    fun testJumpInstructionValidAddress() {
        // Create a CPU instance
        val cpu = CPU()

        // Create the JumpInstruction instance
        val jumpInstruction = JumpInstruction()

        // Create an instruction string "5aaa" where aaa is the address
        val instruction = "51F2" // This means jump to address 1F2

        // Execute the instruction
        jumpInstruction.execute(cpu, instruction)

        // Check if the program counter was set correctly
        assertEquals(0x1F2, cpu.programCounter.value)
    }

    @Test
    fun testJumpInstructionInvalidAddress() {
        // Create a CPU instance
        val cpu = CPU()

        // Create the JumpInstruction instance
        val jumpInstruction = JumpInstruction()

        // Create an instruction string "5aaa" where aaa is the address
        val instruction = "51F3" // This means jump to address 1F3 which is not divisible by 2

        // Execute the instruction and assert failure
        assertFailsWith<IllegalArgumentException> {jumpInstruction.execute(cpu, instruction)}

    }
}