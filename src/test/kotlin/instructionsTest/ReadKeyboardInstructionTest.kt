package instructionsTest

import org.example.CPU
import org.example.Keyboard
import org.example.instructions.ReadKeyboardInstruction
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.Test
import org.mockito.Mockito.*
import kotlin.test.assertEquals


class ReadKeyboardInstructionTest {

    @Test
    fun testReadKeyboardInstructionValidInput() {
        // Create a CPU instance
        val cpu = CPU()

        // Mock the Keyboard class
        val mockKeyboard = mock(Keyboard::class.java)
        cpu.keyboard = mockKeyboard

        // Simulate valid keyboard input
        `when`(mockKeyboard.readInput()).thenReturn("A")

        // Create the ReadKeyboardInstruction instance
        val readKeyboardInstruction = ReadKeyboardInstruction()

        // Create an instruction string "6x00" where x is the register index
        val instruction = "6200"

        // Execute the instruction
        readKeyboardInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(0xA.toByte(), cpu.registers[2])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testReadKeyboardInstructionEmptyInput() {
        // Create a CPU instance
        val cpu = CPU()

        // Mock the Keyboard class
        val mockKeyboard = mock(Keyboard::class.java)
        cpu.keyboard = mockKeyboard

        // Simulate empty keyboard input
        `when`(mockKeyboard.readInput()).thenReturn("")

        // Create the ReadKeyboardInstruction instance
        val readKeyboardInstruction = ReadKeyboardInstruction()

        // Create an instruction string "6x00" where x is the register index
        val instruction = "6200"

        // Execute the instruction
        readKeyboardInstruction.execute(cpu, instruction)

        // Check if the result is correct
        assertEquals(0x0.toByte(), cpu.registers[2])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testReadKeyboardInstructionInvalidInput() {


        // Create a CPU instance
        val cpu = CPU()

        // Mock the Keyboard class
        val mockKeyboard = mock(Keyboard::class.java)
        cpu.keyboard = mockKeyboard

        // Simulate invalid keyboard input
        `when`(mockKeyboard.readInput()).thenReturn("G")

        // Create the ReadKeyboardInstruction instance
        val readKeyboardInstruction = ReadKeyboardInstruction()

        // Create an instruction string "6x00" where x is the register index
        val instruction = "6200" // This means read keyboard input and store in register 2

        // Execute the instruction
        val exception = assertThrows(IllegalArgumentException::class.java) {
            readKeyboardInstruction.execute(cpu, instruction)
        }
        assertEquals("Invalid input: Only base-16 digits (0-F) are allowed", exception.message)
    }

}
