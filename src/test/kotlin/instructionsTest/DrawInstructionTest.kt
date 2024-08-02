package instructionsTest

import org.example.CPU
import org.example.Emulator
import org.example.instructions.DrawInstruction
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.Test

class DrawInstructionTest {

    @Test
    fun testDrawInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu
        val screen = emulator.screen

        // Set initial values in the registers
        cpu.registers[1] = 'A'.code.toByte() // Set r1 to ASCII value for 'A'
        cpu.registers[2] = 3.toByte() // Set r2 to row 3
        cpu.registers[3] = 4.toByte() // Set r3 to column 4

        // Create the DrawInstruction instance
        val drawInstruction = DrawInstruction()

        // Create an instruction string "FrXrYrZ" where X, Y, Z are the register indices
        val instruction = "F123" // This means draw the ASCII character in r1 at row 3 and column 4

        // Execute the instruction
        drawInstruction.execute(emulator, instruction)

        // Calculate the address based on row and column
        // -1 because start at 0
        val address = 2 * screen.width + 3

        // Check if the ASCII value was stored correctly in the screen's internal RAM
        assertEquals('A'.toByte(), screen.ram[address])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testDrawInstructionValueOutOfRange() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Set initial values in the registers
        cpu.registers[1] = 0x80.toByte() // Set r1 to 0x80 (128 in decimal, out of range for ASCII)

        // Create the DrawInstruction instance
        val drawInstruction = DrawInstruction()

        // Create an instruction string "FrXrYrZ" where X, Y, Z are the register indices
        val instruction = "F100"

        // Execute the instruction and expect an exception
        val exception = assertThrows(IllegalArgumentException::class.java) {
            drawInstruction.execute(emulator, instruction)
        }
        kotlin.test.assertEquals("Value in register is greater than 127", exception.message)
    }
}