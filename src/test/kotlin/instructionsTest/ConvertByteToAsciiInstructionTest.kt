package instructionsTest

import org.example.Emulator
import org.example.instructions.ConvertByteToAsciiInstruction
import org.junit.jupiter.api.Assertions.assertThrows
import kotlin.test.Test
import kotlin.test.assertEquals

@OptIn(ExperimentalUnsignedTypes::class)
class ConvertByteToAsciiInstructionTest {

    @Test
    fun testConvertByteToAsciiInstruction() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Set initial values in the registers
        cpu.registers[0] = 0xA.toUByte() // Set r0 to 0xA (10 in decimal)

        // Create the ConvertByteToAsciiInstruction instance
        val convertByteToAsciiInstruction = ConvertByteToAsciiInstruction()

        // Create an instruction string "ErXrY0" where X is the source register and Y is the destination register
        val instruction = "E010"

        // Execute the instruction
        convertByteToAsciiInstruction.execute(emulator, instruction)

        // Check if the ASCII value was stored correctly in r1
        println(cpu.registers[1])
        assertEquals('A'.code.toUByte(), cpu.registers[1])
        // Check if the program counter was incremented correctly
        assertEquals(2, cpu.programCounter.value)
    }

    @Test
    fun testConvertByteToAsciiInstructionValueOutOfRange() {
        // Create an emulator instance
        val emulator = Emulator()
        val cpu = emulator.cpu

        // Set initial values in the registers
        cpu.registers[0] = 0x10.toUByte() // Set r0 to 0x10 (16 in decimal, out of range for hex digit)

        // Create the ConvertByteToAsciiInstruction instance
        val convertByteToAsciiInstruction = ConvertByteToAsciiInstruction()

        // Create an instruction string "ErXrY0" where X is the source register and Y is the destination register
        val instruction = "E010"


        // Execute the instruction and expect an exception
        val exception = assertThrows(IllegalArgumentException::class.java) {
            convertByteToAsciiInstruction.execute(emulator, instruction)
        }
        assertEquals("Value in register is greater than F", exception.message)

    }
}